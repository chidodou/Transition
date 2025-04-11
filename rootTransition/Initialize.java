public class Initialize {
    private final ScreenMenu mainMenu;
    private final ScreenSettings screenSettings;

    public Initialize(Window w) {
        mainMenu = new ScreenMenu(w);
        screenSettings = new ScreenSettings(w);
    }

    public void initialize() {
        mainMenu.init();
        screenSettings.init();
    }

    public ScreenMenu getMainMenu() {
        return mainMenu;
    }

    public ScreenSettings getScreenGame() {
        return screenSettings;
    }
}
