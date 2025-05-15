/**
 * Handles the metadata/info and initializes each map in a list to appear
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;


public class BeatmapManager {
    private List<BeatmapInfo> beatmaps = new ArrayList<>();

    public BeatmapManager() {
        File songsDir = new File("rootTransition/songs");
        if (!songsDir.exists()) songsDir.mkdirs();

        for (File folder : Objects.requireNonNull(songsDir.listFiles())) {
            if (folder.isDirectory()) {
                File mapFile = new File(folder, "map.json");
                if (mapFile.exists()) {
                    try {
                        String json = new String(Files.readAllBytes(mapFile.toPath()));
                        Gson gson = new Gson();
                        Beatmap beatmap = gson.fromJson(json, Beatmap.class);
                        if (beatmap != null && beatmap.title != null) {
                            beatmaps.add(new BeatmapInfo(beatmap.title, mapFile.getAbsolutePath()));
                        }
                        else {
                            System.err.println("Invalid or incomplete map.json: " + mapFile.getAbsolutePath());
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void handleDroppedFile(String path) {
        File dropped = new File(path);
        if (!dropped.getName().endsWith(".mp3")) return;

        try {
            // Folder name based on file name (without extension)
            String folderName = dropped.getName().substring(0, dropped.getName().lastIndexOf('.'));
            File targetDir = new File("rootTransition/songs", folderName);
            if (!targetDir.exists()) targetDir.mkdirs();

            // Move MP3
            File targetMp3 = new File(targetDir, "audio.mp3");
            Files.copy(dropped.toPath(), targetMp3.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Create default beatmap JSON
            Beatmap map = new Beatmap();
            map.title = folderName;
            map.audioFile = "audio.mp3";
            map.notes = new ArrayList<>();
            map.bpm = "";

            Mp3File mp3 = null;
            int tries = 0;
            while (mp3 == null && tries < 5) {
                try {
                    mp3 = new Mp3File(targetMp3);
                } catch (IOException | InvalidDataException | UnsupportedTagException e) {
                    try {
                        Thread.sleep(100); // wait a bit and try again
                    } catch (InterruptedException ignored) {}
                    tries++;
                }
            }

            if (mp3 != null) {
                long durationMs = mp3.getLengthInMilliseconds();
                map.msLength = Long.toString(durationMs);
            } else {
                System.err.println("Could not load MP3 file: " + targetMp3.getAbsolutePath());
                return; // or throw an exception
            }



            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(map);

            Files.write(new File(targetDir, "map.json").toPath(), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<BeatmapInfo> getBeatmaps() { return beatmaps; }
    public BeatmapInfo getBeatmap(int index) { return beatmaps.get(index); }
    public int getCount() { return beatmaps.size(); }
}
