import java.util.ArrayList;
import java.util.List;

public class BeatmapManager {
    private List<BeatmapInfo> beatmaps = new ArrayList<>();

    public BeatmapManager() {
        //
        beatmaps.add(new BeatmapInfo("Chest Pain", "Artist A", "res/song1.txt"));
        beatmaps.add(new BeatmapInfo("Guinea Pig Bridge", "Artist B", "res/song2.txt"));
        beatmaps.add(new BeatmapInfo("Title Screen", "Artist C", "res/song3.txt"));
    }

    public List<BeatmapInfo> getBeatmaps() { return beatmaps; }
    public BeatmapInfo getBeatmap(int index) { return beatmaps.get(index); }
    public int getCount() { return beatmaps.size(); }
}
