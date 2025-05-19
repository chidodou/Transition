public class Note {
    public enum State { WAITING, HIT, MISS, DONE }

    private static final long HIT_WINDOW_MS = 100;
    private static final long FADE_DURATION_MS = 400;

    private float targetX, targetY;
    private float x, y;
    private long spawnTime, hitTime;
    private float fadeAlpha = 255f;
    private State state = State.WAITING;
    private int targetIndex;


    public Note(float targetX, float targetY, long spawnTime, long hitTime, int targetIndex) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.x = targetX;
        this.y = 0;
        this.spawnTime = spawnTime;
        this.hitTime = hitTime;
        this.targetIndex = targetIndex;

    }

    public void update(long currentTime, double mouseX, double mouseY) {
        if (state == State.DONE) return;

        if (currentTime < spawnTime) {
            return;
        }

        if (state == State.WAITING) {
            if (currentTime >= hitTime - HIT_WINDOW_MS && currentTime <= hitTime + HIT_WINDOW_MS) {
                // In hit window
                y = targetY;
                if (isHovered(mouseX, mouseY)) {
                    state = State.HIT;
                }
            } else if (currentTime > hitTime + HIT_WINDOW_MS) {
                state = State.MISS;
            } else {
                // Falling animation
                float progress = (float) (currentTime - spawnTime) / (hitTime - spawnTime);
                y = progress * (targetY - 0);
            }
        }

        if (state == State.MISS) {
            // Fade out
            float elapsed = currentTime - (hitTime + HIT_WINDOW_MS);
            fadeAlpha = 255f - (elapsed * 255f / FADE_DURATION_MS);
            if (fadeAlpha <= 0) {
                state = State.DONE;
            }
        }

        if (state == State.HIT) {
            fadeAlpha = 255f; // Could fade if you want
            state = State.DONE;
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        double dx = mouseX - x;
        double dy = mouseY - y;
        return Math.sqrt(dx * dx + dy * dy) <= 40;
    }

    public boolean hasSpawned(long currentTime) {
        return currentTime >= spawnTime && state != State.DONE;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getAlpha() { return fadeAlpha; }
    public State getState() { return state; }
    public int getTargetIndex() { return targetIndex; }
    public long getHitTime() { return hitTime; }
    public long getSpawnTime() { return spawnTime; }

}
