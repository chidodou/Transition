import com.google.gson.Gson;
import org.lwjgl.nanovg.NVGColor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nanovg.NanoVG.*;

public class ScreenGame {
    private Clickable clickableBack;
    double[] mouseX;
    double[] mouseY;
    boolean[] isMouseDown;
    Window w;
    private Beatmap loadedBeatmap;

    private final float gridWidth = 512f;
    private final float gridHeight = 384f;
    private final float hexRadius = 40f;

    private final float hexHeight = (float) (Math.sqrt(3) * hexRadius); // ~69.28
    private final float hexWidth = 2 * hexRadius; // 80
    private final float horizSpacing = 0.75f * hexWidth; // 60
    private final float vertSpacing = hexHeight; // 69.28

    private final float offsetX = (1366 - gridWidth) / 2f; // center horizontally
    private final float offsetY = (768 - gridHeight) / 2f; // center vertically

    private List<float[]> hexCenters = new ArrayList<>();

    public ScreenGame(Window w) {
        this.w = w;
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
            w.setScreen(Window.ScreenState.SCREEN_SELECT);
        }
    }



    public void loadBeatmap(String filePath) {
        try {
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            loadedBeatmap = new Gson().fromJson(json, Beatmap.class);
            System.out.println("Loaded beatmap: " + loadedBeatmap.title);
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
}
