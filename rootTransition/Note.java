public class Note {
    private float targetX, targetY; // hexagon target position
    private float x, y;             // current position (falling)
    private long spawnTime;         // when note starts falling (in ms)
    private long hitTime;           // when note should reach the hex position (in ms)
    private boolean reached;

    public Note(float targetX, float targetY, long spawnTime, long hitTime) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.x = targetX;
        this.y = 0;          // start from top of screen (y=0)
        this.spawnTime = spawnTime;
        this.hitTime = hitTime;
        this.reached = false;
    }

    // Update current position based on current time in milliseconds
    public void update(long currentTime) {
        if (currentTime < spawnTime) {
            // Not started yet, stay at top
            return;
        }
        if (currentTime >= hitTime) {
            y = targetY;
            reached = true;
            return;
        }
        float progress = (float)(currentTime - spawnTime) / (hitTime - spawnTime);
        y = progress * (targetY - 0); // linear interpolation from 0 to targetY
    }

    public boolean isReached() {
        return reached;
    }

    public float getX() { return x; }
    public float getY() { return y; }
}
