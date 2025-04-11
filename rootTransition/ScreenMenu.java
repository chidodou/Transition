import org.lwjgl.nanovg.NVGColor;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nanovg.NanoVG.*;

public class ScreenMenu {
    private Clickable clickableSettings, clickableGame, clickableExit;
    double[] mouseX;
    double[] mouseY;
    boolean[] isMouseDown;
    Window w;

    public ScreenMenu(Window w) { this.w = w; }

    public void renderTitleText(long vg) {
        nvgFontSize(vg, 48.0f);
        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_MIDDLE);

        NVGColor color = NVGColor.create();
        nvgRGBA((byte) 255, (byte) 255, (byte) 255, (byte) 255, color);  // White

        nvgFillColor(vg, color);
        nvgText(vg, 650, 200, "Title");
    }

    public void init() {
        clickableExit = new Clickable(550, 600, 200, 60, "Exit");
        clickableSettings = new Clickable(550, 500, 200, 60, "Settings"); // Will go to GAME_SCREEN
        clickableGame = new Clickable(550, 400, 200, 60, "Play");
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
        clickableExit.update(mouseX[0], mouseY[0], isMouseDown[0]);
        clickableSettings.update(mouseX[0], mouseY[0], isMouseDown[0]);
        clickableGame.update(mouseX[0], mouseY[0], isMouseDown[0]);

        if (clickableExit.wasClicked()) {
            glfwSetWindowShouldClose(w.window, true);
        }

        if (clickableSettings.wasClicked()) {
            w.setScreen(Window.ScreenState.SCREEN_SETTINGS);
        }

        if (clickableGame.wasClicked()) {
            w.setScreen(Window.ScreenState.SCREEN_GAME);
        }

    }

    public void render() {
        clickableSettings.render(w.vg);
        clickableGame.render(w.vg);
        clickableExit.render(w.vg);
    }
}
