import static org.lwjgl.glfw.GLFW.*;

public class Keyboard {
    private static boolean[] keys = new boolean[GLFW_KEY_LAST];

    public static void setKey(int key, boolean pressed) {
        if (key >= 0 && key < keys.length) {
            keys[key] = pressed;
        }
    }

    public static boolean isKeyPressed(int key) {
        return keys[key];
    }
}