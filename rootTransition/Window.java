import org.lwjgl.glfw.GLFWDropCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;
import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nanovg.NanoVG.nvgBeginFrame;
import static org.lwjgl.nanovg.NanoVG.nvgEndFrame;
import static org.lwjgl.nanovg.NanoVGGL2.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {

    // The window handle
    long window;
    long vg;
    private ScreenMenu screenMenu;
    private ScreenSettings screenSettings;
    private ScreenSelect screenSelect;
    private ScreenEdit screenEdit;
    private BeatmapManager beatmapManager = new BeatmapManager();
    private ScreenGame screenGame;



    private ScreenState currentScreen = ScreenState.SCREEN_MENU;

    public void start() {
        init();
        loop();

        // Free the NanoVG context
        nvgDelete(vg);

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();
    }

    private void init() {
        //Initialize init = new Initialize(this);

        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(1366, 768, "Transition", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(window, true);
            if (key >= 0 && key < GLFW_KEY_LAST) {
                if (action == GLFW_PRESS) {
                    Keyboard.setKey(key, true);
                } else if (action == GLFW_RELEASE) {
                    Keyboard.setKey(key, false);
                }
            }
        });

        glfwSetDropCallback(window, (windowHandle, count, names) -> {
            for (int i = 0; i < count; i++) {
                String path = GLFWDropCallback.getName(names, i);
                beatmapManager.handleDroppedFile(path);
                screenSelect.reloadSongs();
            }
        });

        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            glfwSetWindowPos(
                    window,
                    (Objects.requireNonNull(vidmode).width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        GL.createCapabilities();

        vg = nvgCreate(NVG_ANTIALIAS | NVG_STENCIL_STROKES);
        if (vg == 0) {
            throw new RuntimeException("Failed to initialize NanoVG");
        }
        Clickable.initFont(vg, "sans.ttf");

        screenMenu = new ScreenMenu(this);
        screenMenu.init();
        screenMenu.detectC();  // Initially active screen

        screenSettings = new ScreenSettings(this);
        screenSettings.init();

        screenSelect = new ScreenSelect(this);
        screenSelect.init();

        screenEdit = new ScreenEdit(this);
        screenEdit.init();

        screenGame = new ScreenGame(this);
        screenGame.init();
    }

    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glClearColor(40 / 255f, 40 / 255f, 40 / 255f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            nvgBeginFrame(vg, 1366, 768, 1.0f);

            switch (currentScreen) {
                case SCREEN_MENU:
                    screenMenu.update();
                    screenMenu.render();
                    screenMenu.renderTitleText(vg);
                    break;

                case SCREEN_SETTINGS:
                    screenSettings.update();
                    screenSettings.render();
                    break;

                case SCREEN_SELECT:
                    screenSelect.update();
                    screenSelect.render();
                    break;

                case SCREEN_EDIT:
                    screenEdit.update();
                    screenEdit.render();
                    break;
                case SCREEN_GAME:
                    screenGame.update();
                    screenGame.render();
                    break;
            }

            nvgEndFrame(vg);
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public enum ScreenState {
        SCREEN_MENU,
        SCREEN_SETTINGS,
        SCREEN_SELECT,
        SCREEN_EDIT,
        SCREEN_GAME
    }

    public void setScreen(ScreenState state) {
        this.currentScreen = state;

        if (state == ScreenState.SCREEN_MENU) { screenMenu.detectC(); }
        else if (state == ScreenState.SCREEN_SETTINGS) { screenSettings.detectC(); }
        else if (state == ScreenState.SCREEN_SELECT) { screenSelect.detectC(); }
        else if (state == ScreenState.SCREEN_EDIT) { screenEdit.detectC(); }
        else if (state == ScreenState.SCREEN_GAME) { screenGame.detectC(); }

    }

    public void startWithBeatmap(String filePath) {
        screenGame.loadBeatmap(filePath);
        setScreen(ScreenState.SCREEN_GAME); // or SCREEN_GAME if you renamed it
    }

}
