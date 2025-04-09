import org.lwjgl.nanovg.*;

import static org.lwjgl.nanovg.NanoVG.*;

public class Clickable {
    private final float x, y, width, height;
    private final String label;

    private boolean hovered = false;
    private boolean clicked = false;
    private boolean wasPressedLastFrame = false;

    public Clickable(float x, float y, float width, float height, String label) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
    }

    public void update(double mouseX, double mouseY, boolean isMouseDown) {
        hovered = mouseX >= x && mouseX <= x + width &&
                mouseY >= y && mouseY <= y + height;

        // Detect click on mouse down transition
        clicked = hovered && isMouseDown && !wasPressedLastFrame;

        wasPressedLastFrame = isMouseDown;
    }

    public void render(long vg) {
        // Button shape
        NVGColor colorResultHandle = NVGColor.create();
        nvgBeginPath(vg);
        nvgRoundedRect(vg, x, y, width, height, 10);
        nvgFillColor(vg, hovered ? nvgRGBA((byte)70, (byte)170, (byte)255, (byte)255, colorResultHandle)
                : nvgRGBA((byte)50, (byte)150, (byte)250, (byte)255, colorResultHandle));
        nvgFill(vg);

        // Border
        nvgStrokeColor(vg, nvgRGBA((byte)30, (byte)100, (byte)200, (byte)255, colorResultHandle));
        nvgStrokeWidth(vg, 2.0f);
        nvgStroke(vg);

        // Label
        nvgFontSize(vg, 24.0f);
        // Load font
        int font = nvgCreateFont(vg, "sans", "sans.ttf");
        if (font == -1) {
            throw new RuntimeException("Could not load font.");
        }
        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_MIDDLE);
        nvgFillColor(vg, nvgRGBA((byte)255, (byte)255, (byte)255, (byte)255, colorResultHandle));
        nvgText(vg, x + width / 2, y + height / 2, label);
    }

    public boolean wasClicked() {
        boolean c = clicked;
        clicked = false;
        return c;
    }
}
