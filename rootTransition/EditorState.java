// Core features for the editor implementation
// - Timeline scrub bar
// - Mouse input: left to place, right to delete, middle to select
// - Ctrl+S for saving JSON with popup feedback

import org.lwjgl.nanovg.NVGColor;

import java.util.List;

import static org.lwjgl.nanovg.NanoVG.*;

public class EditorState {
    private Beatmap beatmap;
    private List<float[]> hexCenters;
    private int selectedHexIndex = -1;
    private long currentTime = 0;
    private boolean showSavePopup = false;
    private long savePopupTime = 0;

    public EditorState(Beatmap beatmap, List<float[]> hexCenters) {
        this.beatmap = beatmap;
        this.hexCenters = hexCenters;
    }

    public void update(double mouseX, double mouseY, boolean[] mouseButtons, boolean ctrlDown, boolean sPressed) {
        currentTime = System.currentTimeMillis() - Audio.getStartTime();

        // Place
        if (mouseButtons[0]) {
            int idx = getHoveredHex(mouseX, mouseY);
            if (idx != -1) {
                beatmap.notes.add(new Beatmap.NoteData(idx, currentTime - 1000, currentTime));
            }
        }

        // Delete
        if (mouseButtons[1]) {
            Beatmap.NoteData toRemove = null;
            for (Beatmap.NoteData n : beatmap.notes) {
                float[] pos = hexCenters.get(n.index);
                if (isHovered(pos[0], pos[1], mouseX, mouseY)) {
                    toRemove = n;
                    break;
                }
            }
            if (toRemove != null) beatmap.notes.remove(toRemove);
        }

        // Select
        if (mouseButtons[2]) {
            int idx = getHoveredHex(mouseX, mouseY);
            selectedHexIndex = idx;
        }

        if (ctrlDown && sPressed) {
            saveToJson();
            showSavePopup = true;
            savePopupTime = System.currentTimeMillis();
        }
    }

    public void render(long vg) {
        renderTimeline(vg);
        renderNotes(vg);

        if (showSavePopup && System.currentTimeMillis() - savePopupTime < 1500) {
            drawText(vg, 683, 700, "Saved!");
        }
    }

    private void renderTimeline(long vg) {
        // Timeline background and marker
        float x = 100 + (currentTime % 10000) / 10000f * 1166;
        nvgBeginPath(vg);
        nvgRect(vg, 100, 50, 1166, 10);
        nvgFillColor(vg, rgba(50, 50, 50, 200));
        nvgFill(vg);

        nvgBeginPath(vg);
        nvgRect(vg, x - 2, 45, 4, 20);
        nvgFillColor(vg, rgba(255, 0, 0, 255));
        nvgFill(vg);
    }

    private void renderNotes(long vg) {
        for (Beatmap.NoteData n : beatmap.notes) {
            float[] pos = hexCenters.get(n.index);
            NVGColor fill = rgba(255, 255, 0, 200);
            drawHex(vg, pos[0], pos[1], 40f, fill);

            if (selectedHexIndex == n.index) {
                drawText(vg, pos[0], pos[1] - 50, "Time: " + n.hitTime + "ms");
            }
        }
    }

    private int getHoveredHex(double mouseX, double mouseY) {
        for (int i = 0; i < hexCenters.size(); i++) {
            float[] pos = hexCenters.get(i);
            if (isHovered(pos[0], pos[1], mouseX, mouseY)) return i;
        }
        return -1;
    }

    private boolean isHovered(float cx, float cy, double mx, double my) {
        double dx = mx - cx, dy = my - cy;
        return Math.sqrt(dx * dx + dy * dy) <= 40;
    }

    private void saveToJson() {
        try {
            String json = new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(beatmap);
            java.nio.file.Files.write(java.nio.file.Paths.get("map.json"), json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private NVGColor rgba(int r, int g, int b, int a) {
        NVGColor color = NVGColor.create();
        nvgRGBA((byte) r, (byte) g, (byte) b, (byte) a, color);
        return color;
    }

    private void drawHex(long vg, float cx, float cy, float r, NVGColor fill) {
        nvgBeginPath(vg);
        for (int i = 0; i < 6; i++) {
            double angle = Math.PI / 3 * i;
            float x = (float) (cx + r * Math.cos(angle));
            float y = (float) (cy + r * Math.sin(angle));
            if (i == 0) nvgMoveTo(vg, x, y);
            else nvgLineTo(vg, x, y);
        }
        nvgClosePath(vg);
        nvgFillColor(vg, fill);
        nvgFill(vg);
    }

    private void drawText(long vg, float x, float y, String text) {
        nvgFontSize(vg, 22f);
        nvgTextAlign(vg, NVG_ALIGN_CENTER | NVG_ALIGN_TOP);
        NVGColor color = rgba(255, 255, 255, 255);
        nvgFillColor(vg, color);
        nvgText(vg, x, y, text);
    }
}
