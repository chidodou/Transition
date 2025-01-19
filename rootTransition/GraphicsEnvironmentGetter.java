import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Locale;

public class GraphicsEnvironmentGetter {
    public static void getFonts() {
        GraphicsEnvironment a = GraphicsEnvironment.getLocalGraphicsEnvironment();
        System.out.println(Arrays.toString(a.getAvailableFontFamilyNames()));
    }
}
