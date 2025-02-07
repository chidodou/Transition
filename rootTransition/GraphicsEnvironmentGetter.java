import java.awt.*;
import java.util.Arrays;

public class GraphicsEnvironmentGetter {
    public static void getFonts() {
        GraphicsEnvironment a = GraphicsEnvironment.getLocalGraphicsEnvironment();
        System.out.println(Arrays.toString(a.getAvailableFontFamilyNames()));
    }
}
