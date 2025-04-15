import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class ScreenEdit {
    private Clickable clickableBack;
    double[] mouseX;
    double[] mouseY;
    boolean[] isMouseDown;
    Window w;

    public ScreenEdit(Window w) { this.w = w; }

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
    }

    public void render() { clickableBack.render(w.vg); }
}
