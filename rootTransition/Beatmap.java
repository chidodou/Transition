import java.util.ArrayList;
import java.util.List;

public class Beatmap {
    public List<Note> notes = new ArrayList<>();

    public void loadFromFile(String path) {
        try {
            List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                float time = Float.parseFloat(parts[0].trim());
                int lane = Integer.parseInt(parts[1].trim());
                int type = Integer.parseInt(parts[2].trim());

                notes.add(new Note(time, lane, type));
            }
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    public List<Note> getNotes() { return notes; }
}
