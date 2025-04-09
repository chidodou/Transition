public interface Screen {
    void update(double mouseX, double mouseY, boolean isMouseDown);
    void render(long vg);
}