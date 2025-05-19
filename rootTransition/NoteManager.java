import org.lwjgl.nanovg.NVGColor;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.nanovg.NanoVG.*;

public class NoteManager {
    private final List<Note> notes = new ArrayList<>();
    private int totalMisses = 0;


    public void loadFromBeatmap(Beatmap map, List<float[]> hexPositions) {
        notes.clear();
        totalMisses = 0;
        for (int i = 0; i < map.notes.size(); i++) {
            Beatmap.NoteData nd = map.notes.get(i);
            float[] pos = hexPositions.get(nd.index);
            notes.add(new Note(pos[0], pos[1], nd.spawnTime, nd.hitTime, nd.index));
        }
    }

    public void update(long currentTime, double mouseX, double mouseY) {
        for (Note note : notes) {
            if (note.hasSpawned(currentTime)) {
                Note.State previous = note.getState();
                note.update(currentTime, mouseX, mouseY);
                if (previous != Note.State.MISS && note.getState() == Note.State.MISS) {
                    totalMisses++;
                }
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

    public boolean isNoteApproaching(int hexIndex, long currentTime, long windowMs) {
        for (Note note : notes) {
            if (note.getState() == Note.State.DONE) continue;
            if (note.getTargetIndex() == hexIndex &&
                    currentTime >= note.getSpawnTime() &&
                    currentTime <= note.getHitTime()) {
                return true;
            }
        }
        return false;
    }


    public int countMisses() {
        int count = 0;
        for (Note note : notes) {
            if (note.getState() == Note.State.MISS) {
                count++;
            }
        }
        return totalMisses;
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
