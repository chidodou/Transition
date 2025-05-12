/**
 * Loads a beatmap and its notes as a json file
 */

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Beatmap {
    public List<Note> notes = new ArrayList<>();
    public int bpm;
    public String title;
    public String audioFile;
    private static final Logger logger = Logger.getLogger(Beatmap.class.getName());

    public void loadFromFile(String path) {
        try {
            List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                float time = Float.parseFloat(parts[0].trim());
                int x = Integer.parseInt(parts[1].trim());
                int y = Integer.parseInt(parts[2].trim());
                int type = Integer.parseInt(parts[3].trim());

                notes.add(new Note(time, x, y, type));
            }
        }
        catch (Exception e) { logger.log(Level.SEVERE, "An unexpected error occurred", e); }
    }

    public List<Note> getNotes() { return notes; }
}
