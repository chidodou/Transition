/**
 * Loads a beatmap and its notes as a json file
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Beatmap {
    public String bpm;
    public String msLength;
    public String title;
    public String audioFile;
    public List<NoteData> notes = new ArrayList<>();

    public static class NoteData {
        public int index;         // index of the hexagon
        public long spawnTime;    // when note starts falling
        public long hitTime;      // when note reaches the target

        public NoteData(int index, long spawnTime, long hitTime) {
            this.index = index;
            this.spawnTime = spawnTime;
            this.hitTime = hitTime;
        }
    }

    public List<NoteData> getNotes() { return notes; }
}
