import com.google.gson.Gson;
import org.lwjgl.nanovg.NVGColor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nanovg.NanoVG.*;
import static org.lwjgl.openal.AL10.*;

public class ScreenGame {
    final float aspectRatio = 4f / 3f;
    private final float gridWidth = 640f;
    private final float gridHeight = 480f;
    private final float hexRadius = 40f;
    private final float hexHeight = (float) (Math.sqrt(3) * hexRadius); // ~69.28
    private final float vertSpacing = hexHeight; // 69.28
    private final float hexWidth = 2 * hexRadius; // 80
    private final float horizSpacing = 0.75f * hexWidth; // 60
    private final float offsetX = (1366 - gridWidth) / 2f; // center horizontally
    private final float offsetY = (768 - gridHeight) / 2f; // center vertically
    double[] mouseX;
    double[] mouseY;
    boolean[] isMouseDown;
    Window w;
    private Clickable clickableBack;
    private Beatmap loadedBeatmap;
    private int audioSource = -1;
    private final List<float[]> hexCenters = new ArrayList<>();
    private String beatmapPath;
    private NoteManager noteManager = new NoteManager();
    private long songStartTime;

    public ScreenGame(Window w) {
        this.w = w;
    }

    public void startAudio(String filePath) throws Exception {
        int buffer = loadSound(filePath);
        audioSource = alGenSources();
        alSourcei(audioSource, AL_BUFFER, buffer);
        alSourcef(audioSource, AL_GAIN, 1.0f);
        alSourcePlay(audioSource);
        int state = alGetSourcei(audioSource, AL_SOURCE_STATE);
        System.out.println("Audio source state after play: " + state);
        int error = alGetError();
        if (error != AL_NO_ERROR) {
            System.err.println("OpenAL error: " + error);
        }
    }

    public void init() {
        clickableBack = new Clickable(100, 650, 200, 60, "Back");
        generateHexGrid();
    }

    public void detectC() {
        mouseX = new double[1];
        mouseY = new double[1];
        isMouseDown = new boolean[1];

        glfwSetCursorPosCallback(w.window, (window, xpos, ypos) -> {
            mouseX[0] = xpos;
            mouseY[0] = ypos;
        });

        glfwSetMouseButtonCallback(w.window, (window, button, action, mods) -> {
            if (button == GLFW_MOUSE_BUTTON_LEFT) {
                isMouseDown[0] = (action == GLFW_PRESS);
            }
        });
    }

    public void update() {
        clickableBack.update(mouseX[0], mouseY[0], isMouseDown[0]);
        if (clickableBack.wasClicked()) {
            stopAudio();
            w.setScreen(Window.ScreenState.SCREEN_SELECT);
        }
        if (audioSource != -1) {
            int state = alGetSourcei(audioSource, AL_SOURCE_STATE);
        }
        long currentTime = System.currentTimeMillis() - songStartTime;
        noteManager.update(currentTime, mouseX[0], mouseY[0]);
    }
    private void stopAudio() {
        if (audioSource != -1) {
            alSourceStop(audioSource);
            alDeleteSources(audioSource);
            audioSource = -1;
        }
    }


    public void loadBeatmap(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            loadedBeatmap = new Gson().fromJson(json, Beatmap.class);
            beatmapPath = filePath; // <-- Save the path
            System.out.println("Loaded beatmap: " + loadedBeatmap.title);
            startAudio(beatmapPath);
            noteManager.loadFromBeatmap(loadedBeatmap, hexCenters);
            songStartTime = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void render() {
        clickableBack.render(w.vg);

        NVGColor color = NVGColor.create();
        nvgRGBA((byte) 255, (byte) 255, (byte) 255, (byte) 150, color);

        for (float[] center : hexCenters) {
            drawHexagon(w.vg, center[0], center[1], hexRadius, color);
        }
        long currentTime = System.currentTimeMillis() - songStartTime;
        noteManager.render(w.vg, mouseX[0], mouseY[0], hexRadius, currentTime);
    }

    private void generateHexGrid() {
        hexCenters.clear();
        int cols = (int) (gridWidth / horizSpacing);
        int rows = (int) (gridHeight / vertSpacing);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                float x = col * horizSpacing + offsetX;
                float y = row * vertSpacing + offsetY;

                // Staggered rows
                if (col % 2 == 1) {
                    y += vertSpacing / 2;
                }

                // Keep within grid bounds
                if (x < offsetX + gridWidth && y < offsetY + gridHeight) {
                    hexCenters.add(new float[]{x, y});
                }
            }
        }
    }

    private void drawHexagon(long vg, float cx, float cy, float r, NVGColor color) {
        nvgBeginPath(vg);
        for (int i = 0; i < 6; i++) {
            double angle = Math.PI / 3 * i;
            float x = (float) (cx + r * Math.cos(angle));
            float y = (float) (cy + r * Math.sin(angle));
            if (i == 0) nvgMoveTo(vg, x, y);
            else nvgLineTo(vg, x, y);
        }
        nvgClosePath(vg);
        nvgStrokeColor(vg, color);
        nvgStrokeWidth(vg, 1.5f);
        nvgStroke(vg);
    }

    // A utility method (create once)
    public int loadSound(String filePath) throws Exception {
        int buffer = alGenBuffers();

        File mapFile = new File(filePath);
        File folder = mapFile.getParentFile();
        File audioFile = new File(folder, "audio.mp3");


        Audio.DecodedMP3 decoded = Audio.decodeMP3(audioFile.getAbsolutePath());
        alBufferData(buffer, decoded.format, decoded.buffer, decoded.sampleRate);
        int error = alGetError();
        if (error != AL_NO_ERROR) {
            System.err.println("OpenAL error: " + error);
        }

        // Don't free decoded.buffer here; keep it until sound no longer needed.

        return buffer;
    }

}
