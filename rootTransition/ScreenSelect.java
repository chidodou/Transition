import org.lwjgl.nanovg.NVGColor;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.nanovg.NanoVG.*;

public class ScreenSelect {
    private Clickable clickableBack;
    double[] mouseX;
    double[] mouseY;
    boolean[] isMouseDown;
    Window w;
    private long lastKeyTime = 0;
    private static final long KEY_COOLDOWN = 200_000_000; // 200ms in nanoseconds
    private boolean prevUpPressed = false;
    private boolean prevDownPressed = false;
    private boolean prevEnterPressed = false;
    private ScreenGame screenGame;


    public ScreenSelect(Window w) { this.w = w; }

    public void init() {
        clickableBack = new Clickable(100, 650, 200, 60, "Back");
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

            w.setScreen(Window.ScreenState.SCREEN_MENU);
        }
        boolean upPressed = Keyboard.isKeyPressed(GLFW_KEY_UP);
        boolean downPressed = Keyboard.isKeyPressed(GLFW_KEY_DOWN);
        boolean enterPressed = Keyboard.isKeyPressed(GLFW_KEY_ENTER);

// DOWN
        if (downPressed && !prevDownPressed) {
            selectedIndex++;
            if (selectedIndex >= manager.getCount()) selectedIndex = 0;
        }

// UP
        if (upPressed && !prevUpPressed) {
            selectedIndex--;
            if (selectedIndex < 0) selectedIndex = manager.getCount() - 1;
        }

// ENTER
        if (enterPressed && !prevEnterPressed) {
            BeatmapInfo selected = manager.getBeatmap(selectedIndex);
            // game.startWithBeatmap(selected.filePath);
        }

// Update previous states
        prevUpPressed = upPressed;
        prevDownPressed = downPressed;
        prevEnterPressed = enterPressed;
    }

    public void render() {
        clickableBack.render(w.vg);
        float startY = 300f;

        for (int i = 0; i < manager.getCount(); i++) {
            String title = manager.getBeatmap(i).title;

            if (i == selectedIndex) {
                // Draw highlighted
                drawText(w.vg, 683, startY + i * 50, title + " <");
            }
            else {
                drawText(w.vg, 683, startY + i * 50, title);
            }
        }
    }

    private void drawText(long vg, float x, float y, String text) {
        nvgFontSize(vg, 36f);
        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_TOP);
        NVGColor color = NVGColor.create();
        nvgRGBA((byte)255, (byte)255, (byte)255, (byte)255, color);
        nvgFillColor(vg, color);
        nvgText(vg, x, y, text);
    }

    public void reloadSongs() {
        manager = new BeatmapManager(); // reload from disk
        selectedIndex = 0; // reset selection or keep current if preferred
    }

    BeatmapManager manager = new BeatmapManager();
    int selectedIndex = 0;
}
