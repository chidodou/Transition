import org.lwjgl.nanovg.NVGColor;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.nanovg.NanoVG.*;

public class NoteManager {
    private final List<Note> notes = new ArrayList<>();

    public void loadFromBeatmap(Beatmap map, List<float[]> hexPositions) {
        notes.clear();
        for (int i = 0; i < map.notes.size(); i++) {
            Beatmap.NoteData nd = map.notes.get(i);
            float[] pos = hexPositions.get(nd.index); // assumes index is valid
            notes.add(new Note(pos[0], pos[1], nd.spawnTime, nd.hitTime));
        }
    }

    public void update(long currentTime, double mouseX, double mouseY) {
        for (Note note : notes) {
            if (note.hasSpawned(currentTime)) {
                note.update(currentTime, mouseX, mouseY);
            }
        }
    }



    public void render(long vg, double mouseX, double mouseY, float radius, long currentTime) {
        for (Note note : notes) {
            if (note.hasSpawned(currentTime)) {
                drawFallingNote(vg, note.getX(), note.getY(), radius, note.getState(), note.getAlpha());
            }
        }
    }

    private void drawFallingNote(long vg, float cx, float cy, float r, Note.State state, float alpha) {
        NVGColor fill = NVGColor.create();

        if (state == Note.State.HIT) {
            nvgRGBA((byte)0, (byte)255, (byte)0, (byte)255, fill); // green full
        } else if (state == Note.State.MISS) {
            nvgRGBA((byte)255, (byte)0, (byte)0, (byte)Math.max(0, Math.min(255, (int)alpha)), fill); // fading red
        } else {
            nvgRGBA((byte)255, (byte)255, (byte)255, (byte)180, fill); // white falling
        }

        nvgBeginPath(vg);
        for (int i = 0; i < 6; i++) {
            double angle = Math.PI / 3 * i;
            float x = (float)(cx + r * Math.cos(angle));
            float y = (float)(cy + r * Math.sin(angle));
            if (i == 0) nvgMoveTo(vg, x, y);
            else nvgLineTo(vg, x, y);
        }
        nvgClosePath(vg);
        nvgFillColor(vg, fill);
        nvgFill(vg);
    }
}
