public class Note {
    // public class for all general notes, disregarding types
    // will be addressed later
    public float time;   // in ms
    public int position;   // which track/lane
    public boolean hit = false; // detector for clicked objects

    public Note(float time, int lane) {
    }

    public void hitNote() {


    }
    public void note() {

    }
    public boolean isHit() { return hit = true;}
}
