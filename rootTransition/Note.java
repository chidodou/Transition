public class Note {
    // public class for all general notes, disregarding types
    // will be addressed later
    public float time;   // in ms
    public int x,y,type;   // which track/lane
    public boolean hit = false; // detector for clicked objects

    public Note(float time, int x, int y, int type) {
        // time: at what position in milliseconds
        // position: x/y coordinate on the screen
        // type: if note is click or no click, or if its a hold note
        // all types of notes referred to as an object/entity
    }

    public void hitNote() {
        // define to hit a note
    }
    public void note() {
        // define the appearing of a note as a renderable object, how it interacts with the editor
    }


    // this one should be simple
    public boolean isHit() { return hit = true;}
}
