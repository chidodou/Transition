/**
 * handles all switches
 * includes bool values, such as 0/1 options for ScreenSettings
 * so apparently i need to figure out OpenGL vsync
 */

import org.lwjgl.nanovg.NVGColor;
import static org.lwjgl.nanovg.NanoVG.*;

public class Switch {
    private final float x, y, width, height;
    private final String label;
    private boolean hovered = false;
    private boolean clicked = false;
    private boolean wasPressedLastFrame = false;
    private boolean off = false;
    private boolean on = true;
    private static int font = -1; // Static font shared by all buttons

    public Switch(float x, float y, float width, float height, String label) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
    }

    // Call this ONCE during setup (e.g., in Window.init())
    public static void initFont(long vg, String fontPath) {
        font = nvgCreateFont(vg, "default", fontPath);
        if (font == -1) { throw new RuntimeException("Could not load font: " + fontPath); }
    }

    public void update(double mouseX, double mouseY, boolean isMouseDown) {
        hovered = mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height;
        clicked = hovered && isMouseDown && !wasPressedLastFrame;
        wasPressedLastFrame = isMouseDown;
    }

    public void render(long vg) {
        NVGColor color = NVGColor.create();

        // Draw a button background
        nvgBeginPath(vg);
        nvgRoundedRect(vg, x, y, width, height, 50);
        nvgFillColor(vg, hovered
                ? nvgRGBA((byte) 70, (byte) 170, (byte) 255, (byte) 255, color)
                : nvgRGBA((byte) 50, (byte) 150, (byte) 250, (byte) 255, color));
        nvgFill(vg);

        // Draw border
        nvgStrokeColor(vg, nvgRGBA((byte) 30, (byte) 100, (byte) 200, (byte) 255, color));
        nvgStrokeWidth(vg, 2.0f);
        nvgStroke(vg);

        // Draw label
        if (font != -1) {
            nvgFontFaceId(vg, font); // Use the loaded font
        }
        nvgFontSize(vg, 24.0f);
        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_MIDDLE);
        nvgFillColor(vg, nvgRGBA((byte) 255, (byte) 255, (byte) 255, (byte) 255, color));
        nvgText(vg, x + width / 2, y + height / 2, label);
    }

    public boolean wasClicked() {
        boolean result = clicked;
        clicked = false; // Reset after reading
        return result;
    }
}

