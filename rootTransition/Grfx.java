// THE Grfx CLASS
// NOTE: HTML <br> (breaks) are used in the documentation so it will look better in Javadoc.

import java.awt.*;

/**
 * Grfx CLASS UPDATE: 11/9/2023 <BR><BR>
 * <p>
 * This class contains several graphics methods and several Color objects originally created
 * by John L. M. Schram for the Deluxe Expo class.  These methods are similar to the commands
 * used in the Graphics library from Computer Science 1. <BR><BR>
 * <p>
 * This code is free software; you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation.  This code is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. <BR><BR>
 */

public class Grfx {
    ////////////////////////////////////////////////////////////////////////////////
    // Color Constants

    // built in colors copied to the Grfx class
    static final Color red = Color.red;
    static final Color green = Color.green;
    static final Color blue = Color.blue;
    static final Color orange = Color.orange;
    static final Color cyan = Color.cyan;
    static final Color magenta = Color.magenta;
    static final Color yellow = Color.yellow;
    static final Color gray = Color.gray;
    static final Color lightGray = Color.lightGray;
    static final Color darkGray = Color.darkGray;
    static final Color pink = Color.pink;
    static final Color black = Color.black;
    static final Color white = Color.white;

    // other colors
    // 4 darker/lighter shades of all the above colors (except for black and white)
    static final Color lightRed = new Color(255, 128, 128);
    static final Color lighterRed = new Color(255, 192, 192);
    static final Color darkRed = new Color(192, 0, 0);
    static final Color darkerRed = new Color(128, 0, 0);
    static final Color lightOrange = new Color(255, 224, 0);
    static final Color lighterOrange = new Color(255, 224, 64);
    static final Color darkOrange = new Color(255, 128, 0);
    static final Color darkerOrange = new Color(255, 64, 0);
    static final Color lightYellow = new Color(255, 255, 128);
    static final Color lighterYellow = new Color(255, 255, 192);
    static final Color darkYellow = new Color(192, 192, 0);
    static final Color darkerYellow = new Color(128, 128, 0);
    static final Color lightGreen = new Color(128, 255, 128);
    static final Color lighterGreen = new Color(192, 255, 192);
    static final Color darkGreen = new Color(0, 128, 0);
    static final Color darkerGreen = new Color(0, 64, 0);
    static final Color lightBlue = new Color(128, 128, 255);
    static final Color lighterBlue = new Color(192, 192, 255);
    static final Color darkBlue = new Color(0, 0, 128);
    static final Color darkerBlue = new Color(0, 0, 64);
    static final Color lightMagenta = new Color(255, 64, 255);
    static final Color lighterMagenta = new Color(255, 128, 255);
    static final Color darkMagenta = new Color(192, 0, 192);
    static final Color darkerMagenta = new Color(128, 0, 128);
    static final Color lightCyan = new Color(128, 255, 255);
    static final Color lighterCyan = new Color(192, 255, 255);
    static final Color darkCyan = new Color(0, 192, 192);
    static final Color darkerCyan = new Color(0, 128, 128);
    static final Color lightPink = new Color(255, 194, 194);
    static final Color lighterPink = new Color(255, 216, 216);
    static final Color darkPink = new Color(240, 150, 150);
    static final Color darkerPink = new Color(224, 128, 128);
    static final Color tan = new Color(210, 180, 140);
    static final Color lightTan = new Color(231, 198, 154);
    static final Color lighterTan = new Color(252, 216, 168);
    static final Color darkTan = new Color(189, 145, 87);
    static final Color darkerTan = new Color(168, 124, 66);
    static final Color lighterGray = new Color(224, 224, 224);
    static final Color darkerGray = new Color(32, 32, 32);

    // special colors (which do not have multiple shades provided)
    static final Color brown = new Color(150, 100, 15);
    static final Color violet = new Color(240, 128, 240);
    static final Color purple = new Color(128, 0, 128);
    static final Color turquoise = new Color(64, 224, 208);
    static final Color plum = new Color(221, 160, 221);
    static final Color indigo = new Color(75, 0, 130);
    static final Color aqua = new Color(0, 255, 255);
    static final Color aquaMarine = new Color(127, 255, 112);
    static final Color goldenRod = new Color(218, 168, 32);
    static final Color gold = new Color(255, 215, 0);
    static final Color silver = new Color(192, 192, 192);
    static final Color bronze = new Color(164, 102, 40);
    static final Color teal = new Color(0, 128, 128);
    static final Color maroon = new Color(128, 0, 0);
    static final Color fuschia = new Color(255, 0, 255);
    static final Color lavender = new Color(230, 230, 250);
    static final Color lime = new Color(50, 205, 50);
    static final Color navy = new Color(0, 0, 128);
    static final Color chartreuse = new Color(127, 255, 0);
    static final Color fireBrick = new Color(178, 34, 34);
    static final Color moccasin = new Color(255, 228, 181);
    static final Color olive = new Color(128, 128, 0);
    static final Color salmon = new Color(250, 128, 114);
    static final Color khaki = new Color(240, 230, 140);
    static final Color crimson = new Color(220, 20, 60);
    static final Color orchid = new Color(218, 112, 214);
    static final Color sienna = new Color(160, 82, 45);
    static final Color melon = new Color(254, 186, 73);
    static final Color tangerine = new Color(243, 132, 0);
    static final Color terraCotta = new Color(226, 114, 91);
    static final Color pumpkin = new Color(152, 118, 54);
    static final Color mahogany = new Color(192, 64, 0);
    static final Color amber = new Color(255, 191, 0);

    // allows for alternative spelling of "grey"
    static final Color grey = gray;
    static final Color lightGrey = lightGray;
    static final Color lighterGrey = lighterGray;
    static final Color darkGrey = darkGray;
    static final Color darkerGrey = darkerGray;
    static final double twoPI = 2 * Math.PI;

    ////////////////////////////////////////////////////////////////////////////////
    // Math Constants based on PI
    static final double halfPI = Math.PI / 2;
    static final double quarterPI = Math.PI / 4;
    static Color currentColor = black;   // The current drawing color being used at any particular time.

    ////////////////////////////////////////////////////////////////////////////////
    // Utility Methods (copied from Util.java)

    /**
     * Returns a "true" random integer in the [min..max] range, inclusive. <BR>
     * Precondition: max > min <br>
     * Example:<br>
     * System.out.println(Grfx.random(100,200)); <br>
     * This will display a random integer between 100 and 200.
     */
    public static int random(int min, int max) {
        int range = max - min + 1;
        int number = (int) (range * Math.random() + min);
        return number;
    }

    /**
     * Delays the output for a specified number of milliseconds (1/1000ths of a second). <br>
     * Examples:<br>
     * Grfx.delay(1000); // pause for 1 second <br>
     * Grfx.delay(2000); // pause for 2 seconds <br>
     * Grfx.delay(500);  // pause for 1/2 of a second <br>
     * Grfx.delay(100);  // pause for 1/10 of a second <br>
     * Grfx.delay(10);   // pause for 1/100 of a second <br>
     * Grfx.delay(1);    // pause for 1/1000 of a second <br>
     */
    public static void delay(int n) {
        long startDelay = System.currentTimeMillis();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.currentTimeMillis();
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Color Methods

    /**
     * Allows the user to change the color, using a Color object parameter. <BR>
     * Example: <br>
     * Grfx.setColor(g,Grfx.red); <br>
     * Changes the graphics color to red.  <BR><br>
     */
    public static void setColor(Graphics g, Color newColor) {
        g.setColor(newColor);
        currentColor = newColor;
    }

    /**
     * Allows the user to change to one of 10 predefined primary colors using a single int parameter.<br>
     * This is especially useful in programs where you want to change from one color to a contrasting color quickly. <br>
     * 0 = black <br>
     * 1 = red <br>
     * 2 = green <br>
     * 3 = blue <br>
     * 4 = orange <br>
     * 5 = cyan <br>
     * 6 = magenta <br>
     * 7 = yellow <br>
     * 8 = gray <br>
     * 9 = pink <br>
     * Any negative number will give you white. <br><br>
     * Example: <br>
     * Grfx.setColor(g,1); <br>
     * Changes the current drawing color to red.
     */
    public static void setColor(Graphics g, int colorNum) {
        colorNum %= 10;
        switch (colorNum) {
            case 0:
                g.setColor(black);
                break;
            case 1:
                g.setColor(red);
                break;
            case 2:
                g.setColor(green);
                break;
            case 3:
                g.setColor(blue);
                break;
            case 4:
                g.setColor(orange);
                break;
            case 5:
                g.setColor(cyan);
                break;
            case 6:
                g.setColor(magenta);
                break;
            case 7:
                g.setColor(gray);
                break;
            case 8:
                g.setColor(yellow);
                break;
            case 9:
                g.setColor(pink);
                break;
            default:
                g.setColor(white);
        }
    }

    /**
     * Allows the user to change the color, using 3 int parameters representing the amount of red, green and blue.<br>
     * This allows for more than 16 million different color combinations. <br>
     * Precondition: All 3 color values need to be between 0 and 255 inclusive. <br>
     * Example: <br>
     * Grfx.setColor(g,190,10,47); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
     */
    public static void setColor(Graphics g, int red, int green, int blue) {
        Color newColor = new Color(red, green, blue);
        g.setColor(newColor);
    }

    /**
     * Allows the user to change the color and transparency using 4 int parameters. <BR>
     * The first 3 represent the amount of red, green and blue.<br>
     * This allows for more than 16 million different color combinations. <br>
     * The fourth int value is the "alpha" value which determines transparency.
     * Small alpha values are more transparent.  Large alpha values are more opaque. <BR>
     * Precondition: All 4 int values need to be between 0 and 255 inclusive. <br>
     * Example: <br>
     * Grfx.setColor(g,190,10,47,128); <br>
     * Changes the current drawing color to the shade of red used in the official Texas Flag
     * and makes it semi-transparent
     */
    public static void setColor(Graphics g, int red, int green, int blue, int alpha) {
        Color newColor = new Color(red, green, blue, alpha);
        g.setColor(newColor);
        currentColor = newColor;
    }

    /**
     * Returns a random Color object which can be any of the 16,000,000+ possible colors.
     */
    public static Color getRandomColor() {
        int red = random(0, 255);
        int green = random(0, 255);
        int blue = random(0, 255);
        Color randomColor = new Color(red, green, blue);
        return randomColor;
    }

    /**
     * Sets the current color to a random color value which can be any of the 16,000,000+ possible colors. <br>
     * Example: <br>
     * Grfx.setRandomColor(g);
     */
    public static void setRandomColor(Graphics g) {
        int red = random(0, 255);
        int green = random(0, 255);
        int blue = random(0, 255);
        Color newColor = new Color(red, green, blue);
        g.setColor(newColor);
        currentColor = newColor;
    }

    /**
     * Sets the entire background to a single color using a Color object parameter. <br>
     * Precondition: The applet window cannot be greater than 4800 X 3600 in size. <br>
     * Postcondition: The current drawing color will not be affected by the background color. <br>
     * Example: <br>
     * Grfx.setBackground(g,Grfx.red); <br>
     * This will make the entire background red.
     */
    public static void setBackground(Graphics g, Color bgColor) {
        g.setColor(bgColor);
        fillRectangle(g, 0, 0, 4800, 3600);
        setColor(g, currentColor);
    }

    /**
     * Sets the entire background to one of 10 predefined primary colors using a single int parameter. <br>
     * 0 = black <br>
     * 1 = red <br>
     * 2 = green <br>
     * 3 = blue <br>
     * 4 = orange <br>
     * 5 = cyan <br>
     * 6 = magenta <br>
     * 7 = yellow <br>
     * 8 = gray <br>
     * 9 = pink <br>
     * Any negative number will give you white. <br><br>
     * Example: <br>
     * Grfx.setBackground(g,1); <br>
     * Changes the background color to red.
     */
    public static void setBackground(Graphics g, int colorNum) {
        colorNum %= 10;
        switch (colorNum) {
            case 0:
                setBackground(g, black);
                break;
            case 1:
                setBackground(g, red);
                break;
            case 2:
                setBackground(g, green);
                break;
            case 3:
                setBackground(g, blue);
                break;
            case 4:
                setBackground(g, orange);
                break;
            case 5:
                setBackground(g, cyan);
                break;
            case 6:
                setBackground(g, magenta);
                break;
            case 7:
                setBackground(g, yellow);
                break;
            case 8:
                setBackground(g, gray);
                break;
            case 9:
                setBackground(g, pink);
                break;
            default:
                setBackground(g, white);
        }
    }

    /**
     * Sets the entire background to a single color using 3 int parameters representing the amount of red, green and blue.<br>
     * This allows for more than 16 million different color combinations. <br>
     * Preconditions: All 3 color values need to be between 0 and 255 inclusive. <br>
     * The applet window cannot be greater than 4800 X 3600 in size. <br>
     * Postcondition: The current drawing color will not be affected by the background color. <br>
     * Example: <br>
     * Grfx.setBackground(g,190,10,47); <br>
     * Changes the background color to the shade of red used in the official Texas Flag
     */

    public static void setBackground(Graphics g, int red, int green, int blue) {
        Color newColor = new Color(red, green, blue);
        setBackground(g, newColor);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Draw Methods

    /**
     * Draws a single pixel at the specified x,y location. <BR>
     * Example: <BR>
     * Grfx.drawPixel(g,100,200); <BR>
     * Draws a very small single dot (pixel) on the computer screen 100 pixels over and 200 pixels down
     */
    public static void drawPixel(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    /**
     * Draws a 5 pixel X 5 pixel "point" whose center is at the specified x,y location. <BR>
     * Example: <BR>
     * Grfx.drawPoint(g,100,200);
     * Draws a larger, more visible (than drawPixel) dot on the computer screen 100 pixels over and 200 pixels down.
     */
    public static void drawPoint(Graphics g, int x, int y) {
        g.fillRect(x - 2, y - 2, 5, 5);
    }

    /**
     * Draws the line segment connecting coordinates x1,y1 and x2,y2. <BR>
     * Example: <BR>
     * Grfx.drawLine(g,100,200,300,400); <BR>
     * Draws a line segment connecting the starting coordinate point (100,200) with the ending point (300,400).
     */
    public static void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.drawLine(x1, y1, x2, y2);
    }

    /**
     * Draws an open rectangle.<br>
     * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
     * Example: <br>
     * Grfx.drawRectangle(g,100,200,300,400); <br>
     * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
     */
    public static void drawRectangle(Graphics g, int x1, int y1, int x2, int y2) {
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        g.drawRect(x1, y1, width, height);
    }

    /**
     * Draws an open rectangle with rounded corners.<br>
     * The first 5 parameters (g and 4 ints) are the same as drawRect.<br>
     * The final parameter "pixels" specifies the pixels used in the rounded corner. <br>
     * Example: <br>
     * Grfx.drawRoundedRectangle(g,100,200,300,400,25);
     */
    public static void drawRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels) {
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        int diameter = pixels * 2;
        g.drawRoundRect(x1, y1, width, height, diameter, diameter);
    }

    /**
     * Draws an open circle.<br>
     * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
     * Example: <br>
     * Grfx.drawCircle(g,300,200,100); <br>
     * Draws an open circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
     */
    public static void drawCircle(Graphics g, int centerX, int centerY, int radius) {
        int diameter = 2 * radius;
        g.drawOval(centerX - radius, centerY - radius, diameter, diameter);
    }

    /**
     * Draws an open oval.<br>
     * The user specifies the x,y coordinate of the center of the oval as well as the horizontal and vertical radii values. <br>
     * Example: <br>
     * Grfx.drawOval(g,300,200,100,50); <br>
     * Draws an open oval with a horizontal radius of 100 pixels and a vertical radius of 50 pixels. <br>
     * The center of this oval is located at the coordinate (300,200).
     */
    public static void drawOval(Graphics g, int centerX, int centerY, int hRadius, int vRadius) {
        int hDiameter = 2 * hRadius;
        int vDiameter = 2 * vRadius;
        g.drawOval(centerX - hRadius, centerY - vRadius, hDiameter, vDiameter);
    }

    /**
     * Draws and arc which is a "piece" of an OVAL.<br>
     * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
     * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
     * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
     * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
     */
    public static void drawArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish) {
        int hDiameter = 2 * hRadius;
        int vDiameter = 2 * vRadius;
        if (finish < start)
            finish += 360;
        int newStart = 90 - start;   // shifts starting position from 3:00 to 12:00
        int newFinish = start - finish; // as opposed to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.
        g.drawArc(centerX - hRadius, centerY - vRadius, hDiameter, vDiameter, newStart, newFinish);
    }

    /**
     * Draws an open irregular triangle using the three sets of provided coordinates. <br>
     * Example: <br>
     * Grfx.drawTriangle(g,100,300,200,100,300,300);
     */
    public static void drawTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon myPoly = new Polygon();
        myPoly.addPoint(x1, y1);
        myPoly.addPoint(x2, y2);
        myPoly.addPoint(x3, y3);
        g.drawPolygon(myPoly);
    }

    /**
     * Draws an open irregular quadrilateral using the four sets of provided coordinates. <br>
     * Example: <br>
     * Grfx.drawQuad(g,100,100,200,300,400,400,300,200);
     */
    public static void drawQuad(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Polygon myPoly = new Polygon();
        myPoly.addPoint(x1, y1);
        myPoly.addPoint(x2, y2);
        myPoly.addPoint(x3, y3);
        myPoly.addPoint(x4, y4);
        g.drawPolygon(myPoly);
    }

    /**
     * Draws an open irregular polygon using 3 or more sets of provided coordinates. <br>
     * Examples: <br>
     * Grfx.drawPolygon(g,100,300,200,100,300,300);                         // for a triangle
     * Grfx.drawPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400); // for a hexagon
     */
    public static void drawPolygon(Graphics g, int... coordinate) {
        if (coordinate.length < 6 || coordinate.length % 2 == 1) {
            int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
            throw new IllegalArgumentException("\nYou have " + coordinate.length +
                    " int parameters in your drawPolygon method call.\n" +
                    "When using drawPolygon, the number of int parameters must be even and no less than 6.");
        } else {
            Polygon myPoly = new Polygon();
            for (int j = 0; j < coordinate.length - 1; j += 2)
                myPoly.addPoint(coordinate[j], coordinate[j + 1]);
            g.drawPolygon(myPoly);
        }
    }

    /**
     * Draws an open regular polygon with a specified number of sides.<br>
     * The center of this polygon is specified by centerX,centerY and its size is specified by radius <br>
     * (As in the radius of the circle the regular polygon would fit inside). <br>
     * Precondition: sides >= 3 <br>
     * Example: <br>
     * Grfx.drawRegularPolygon(g,300,200,100,8); <br>
     * Draws an open regular polygon with 8 sides and a radius of 100 pixels whose center is located at the coordinate (300,200).
     */
    public static void drawRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides) {
        int[] xCoord = new int[sides];
        int[] yCoord = new int[sides];
        double rotate;
        if (sides % 2 == 1)
            rotate = halfPI;
        else
            rotate = halfPI + Math.PI / sides;
        for (int k = 0; k < sides; k++) {
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k / sides - rotate) * radius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k / sides - rotate) * radius) + centerY;
        }
        if (sides == 3)
            yCoord[1] = yCoord[2];
        g.drawPolygon(xCoord, yCoord, sides);
    }

    /**
     * Draws an open star with a specified number of points.<br>
     * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
     * (As in the radius of the circle the star would fit inside). <br>
     * Precondition: points >= 2 <br>
     * Example: <br>
     * Grfx.drawStar(g,300,200,100,8); <br>
     * Draws an open star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
     */
    public static void drawStar(Graphics g, int centerX, int centerY, int radius, int points) {
        int halfRadius = getHalfRadius(radius, points);
        int p = points;
        points *= 2;
        int[] xCoord = new int[points];
        int[] yCoord = new int[points];
        int currentRadius;
        for (int k = 0; k < points; k++) {
            if (k % 2 == 0)
                currentRadius = radius;
            else
                currentRadius = halfRadius;
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k / points - halfPI) * currentRadius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k / points - halfPI) * currentRadius) + centerY;
        }
        int x = (p - 5) / 2 + 1;
        if (p >= 5 && p <= 51)
            switch (p % 4) {
                case 1:
                    yCoord[x] = yCoord[x + 1] = yCoord[points - x - 1] = yCoord[points - x];
                    break;
                case 2:
                    yCoord[x] = yCoord[x + 1] = yCoord[points - x - 1] = yCoord[points - x];
                    yCoord[x + 3] = yCoord[x + 4] = yCoord[points - x - 4] = yCoord[points - x - 3];
                    break;
                case 3:
                    yCoord[x + 2] = yCoord[x + 3] = yCoord[points - x - 3] = yCoord[points - x - 2];
            }
        g.drawPolygon(xCoord, yCoord, points);
    }

    /**
     * Draws a certain number of lines (numLines) in a burst like pattern.<br>
     * The lines are evenly spaced and drawn from the center of a circle to its edge.<br>
     * The size of the circle is specified by the radius parameter. <br>
     * Example: <br>
     * Grfx.drawBurst(g,300,200,100,50); <br>
     * Draws a "burst" with a radius of 100 pixels whose center is located at the coordinate (300,200). <br>
     * The "burst" will be comprised of 50 evenly spaced lines.
     */
    public static void drawBurst(Graphics g, int centerX, int centerY, int radius, int numLines) {
        double offSet;
        if (numLines % 2 == 1)
            offSet = halfPI;
        else
            offSet = halfPI + Math.PI / numLines;
        for (double radian = 0; radian < twoPI; radian += twoPI / numLines) {
            int x = (int) Math.round(Math.cos(radian - offSet) * radius) + centerX;
            int y = (int) Math.round(Math.sin(radian - offSet) * radius) + centerY;
            g.drawLine(centerX, centerY, x, y);
        }
    }

    /**
     * Draws a spiral.
     * The center of the spiral is specified with the centerX,centerY parameters. <BR>
     * The maxRadius parameter determines the size of the spiral. <BR>
     * (It is actually the radius of the circle that the spiral would fit inside.) <BR>
     * The spacing is controlled by the "spacing" parameter.  <BR>
     * Example: <BR>
     * Grfx.drawSpiral(g,300,200,100,25); <BR>
     * Draws a spiral with a maxRadius of 100 pixels whose center is located at the coordinate (300,200). <BR>
     * There are precisely 25 pixels separating each "loop" of the spiral. <BR>
     */
    public static void drawSpiral(Graphics g, int centerX, int centerY, int maxRadius, double spacing) {
        double spiralInc = spacing / (twoPI * 1000);
        double spiralRadius = 0;
        double radian = 0;
        while (spiralRadius <= maxRadius) {
            int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
            int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
            drawPixel(g, x, y);
            radian += 0.001;
            spiralRadius += spiralInc;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Draw Thick Methods

    /**
     * Draws a "thick" line segment connecting coordinates x1,y2 and x2,y2.<br>
     * The thickness is specified in the last parameter. <br>
     * Example: <br>
     * Grfx.drawThickLine(g,100,200,300,400,5); <br>
     * Draws a "thick" line segment connecting the starting coordinate point (100,200) with the ending point (300,400). <br>
     * The line will be 5 pixels thick.
     */
    public static void drawThickLine(Graphics g, int x1, int y1, int x2, int y2, int thickness) {
        if (thickness < 2)
            thickness = 2;
        int start = -thickness / 2;
        int finish;
        if (thickness % 2 == 0)
            finish = thickness / 2;
        else
            finish = thickness / 2 - 1;
        for (int x = start; x <= finish; x++)
            for (int y = start; y <= finish; y++)
                g.drawLine(x1 + x, y1 + y, x2 + x, y2 + y);
    }

    /**
     * Draws a "thick" open rectangle.<br>
     * The parameters are the same as drawRectangle, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickRectangle(Graphics g, int x1, int y1, int x2, int y2, int thickness) {
        if (thickness < 2)
            thickness = 2;
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        for (int j = 0; j < thickness; j++)
            g.drawRect(x1 + j, y1 + j, width - 2 * j, height - 2 * j);
    }

    /**
     * Draws an "thick" open rectangle with rounded corners.<br>
     * The parameters are the same as drawRoundedRectangle, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels, int thickness) {
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        int diameter = pixels * 2;
        if (thickness < 2)
            thickness = 2;
        thickness--;
        for (int j = 0; j < thickness; j++)
            g.drawRoundRect(x1 + j, y1 + j, width - 2 * j, height - 2 * j, diameter, diameter);
        x1++;
        for (int j = 0; j < thickness; j++)
            g.drawRoundRect(x1 + j, y1 + j, width - 2 * j, height - 2 * j, diameter, diameter);
        y1++;
        for (int j = 0; j < thickness; j++)
            g.drawRoundRect(x1 + j, y1 + j, width - 2 * j, height - 2 * j, diameter, diameter);
        x1--;
        for (int j = 0; j < thickness; j++)
            g.drawRoundRect(x1 + j, y1 + j, width - 2 * j, height - 2 * j, diameter, diameter);
    }

    /**
     * Draws a "thick" circle.<br>
     * The user specifies the x,y coordinate of the center of the circle as well as the radius value.<br>
     * The thickness is specified in the last parameter. <br>
     * Example: <br>
     * Grfx.drawThickCircle(g,300,200,100,5); <br>
     * Draws a "thick" open circle with a radius of 100 pixels whose center is located at coordinate (300,200). <br>
     * The edge of this circle will be 5 pixels thick.
     */
    public static void drawThickCircle(Graphics g, int centerX, int centerY, int radius, int thickness) {
        int diameter = 2 * radius - 1;
        if (thickness < 2)
            thickness = 2;
        thickness--;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - radius + j, centerY - radius + j, diameter - 2 * j, diameter - 2 * j);
        centerX++;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - radius + j, centerY - radius + j, diameter - 2 * j, diameter - 2 * j);
        centerY++;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - radius + j, centerY - radius + j, diameter - 2 * j, diameter - 2 * j);
        centerX--;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - radius + j, centerY - radius + j, diameter - 2 * j, diameter - 2 * j);
    }

    /**
     * Draws a "thick" oval.<br>
     * The user specifies the x,y coordinate of the center of the circle as well as the radius value.<br>
     * The thickness is specified in the last parameter. <br>
     * Example: <br>
     * Grfx.drawThickOval(g,300,200,100,50,5); <br>
     * Draws a "thick" open oval with a horizontal radius of 100 pixels and a verticle radius of 50
     * whose center is located at the coordinate (300,200). <br>
     * The edge of this oval will be 5 pixels thick.
     */
    public static void drawThickOval(Graphics g, int centerX, int centerY, int hr, int vr, int thickness) {
        int width = 2 * hr - 1;
        int height = 2 * vr - 1;
        if (thickness < 2)
            thickness = 2;
        thickness--;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - hr + j, centerY - vr + j, width - 2 * j, height - 2 * j);
        centerX++;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - hr + j, centerY - vr + j, width - 2 * j, height - 2 * j);
        centerY++;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - hr + j, centerY - vr + j, width - 2 * j, height - 2 * j);
        centerX--;
        for (int j = 0; j < thickness; j++)
            g.drawOval(centerX - hr + j, centerY - vr + j, width - 2 * j, height - 2 * j);
    }

    /**
     * Draws a "thick" arc which will look like a thick curved line.<br>
     * The parameters are the same as drawArc, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish, int thickness) {
        int hDiameter = 2 * hRadius - 1;
        int vDiameter = 2 * vRadius - 1;
        if (thickness < 2)
            thickness = 2;
        thickness--;
        for (int j = 0; j < thickness; j++)
            drawArc(g, centerX, centerY, hRadius - j, vRadius - j, start, finish);
        centerX++;
        for (int j = 0; j < thickness; j++)
            drawArc(g, centerX, centerY, hRadius - j, vRadius - j, start, finish);
        centerY++;
        for (int j = 0; j < thickness; j++)
            drawArc(g, centerX, centerY, hRadius - j, vRadius - j, start, finish);
        centerX--;
        for (int j = 0; j < thickness; j++)
            drawArc(g, centerX, centerY, hRadius - j, vRadius - j, start, finish);
    }

    /**
     * Draws an "thick" open irregular triangle using the three sets of provided coordinates.<br>
     * The parameters are the same as drawTriangle, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int thickness) {
        for (int x = 0; x < thickness; x++)
            for (int y = 0; y < thickness; y++)
                drawTriangle(g, x1 + x, y1 + y, x2 + x, y2 + y, x3 + x, y3 + y);
    }

    /**
     * Draws an "thick" open irregular quadrilateral using the four sets of provided coordinates.<br>
     * The parameters are the same as drawQuad, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickQuad(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int thickness) {
        for (int x = 0; x < thickness; x++)
            for (int y = 0; y < thickness; y++)
                drawQuad(g, x1 + x, y1 + y, x2 + x, y2 + y, x3 + x, y3 + y, x4 + x, y4 + y);
    }

    /**
     * Draws a "thick" open irregular polygon using 3 or more sets of provided coordinates. <br>
     * The parameters are the same as drawQuad, except there is an extra parameter at the end for the thickness. <br>
     * <p>
     * Examples: <br>
     * Grfx.drawThickPolygon(g,100,300,200,100,300,300,10);                         // for a 10-pixel thick triangle
     * Grfx.drawThickPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400,25); // for a 25-pixel thick hexagon
     */
    public static void drawThickPolygon(Graphics g, int... coordinate) {
        if (coordinate.length < 7 || coordinate.length % 2 == 0) {
            int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
            throw new IllegalArgumentException("\nYou have " + coordinate.length +
                    " int parameters in your drawPolygon method call.\n" +
                    "When using drawThickPolygon, the number of int parameters must be odd and no less than 7.");
        } else {
            int thickness = coordinate[coordinate.length - 1];
            for (int x = 0; x < thickness; x++)
                for (int y = 0; y < thickness; y++) {
                    Polygon myPoly = new Polygon();
                    for (int j = 0; j < coordinate.length - 1; j += 2)
                        myPoly.addPoint(coordinate[j] + x, coordinate[j + 1] + y);
                    g.drawPolygon(myPoly);
                }
        }
    }

    /**
     * Draws a "thick" regular polygon with a specified number of sides.<br>
     * The parameters are the same as drawRegularPolygon, except there is an extra parameter at the end for the thickness. <br>
     * Precondition: sides >= 3
     */
    public static void drawThickRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides, int thickness) {
        int[] xCoord = new int[sides];
        int[] yCoord = new int[sides];
        double rotate;
        if (sides % 2 == 1)
            rotate = halfPI;
        else
            rotate = halfPI + Math.PI / sides;
        if (thickness > radius)
            thickness = radius;
        if (thickness < 2)
            thickness = 2;
        thickness--;
        for (int currentRadius = radius; currentRadius > radius - thickness; currentRadius -= 0.1)
            drawRegularPolygon(g, centerX, centerY, currentRadius, sides);
        centerX++;
        for (int currentRadius = radius; currentRadius > radius - thickness; currentRadius -= 0.1)
            drawRegularPolygon(g, centerX, centerY, currentRadius, sides);
        centerY++;

        for (int currentRadius = radius; currentRadius > radius - thickness; currentRadius -= 0.1)
            drawRegularPolygon(g, centerX, centerY, currentRadius, sides);
        centerX--;
        for (int currentRadius = radius; currentRadius > radius - thickness; currentRadius -= 0.1)
            drawRegularPolygon(g, centerX, centerY, currentRadius, sides);
    }

    /**
     * Draws a "thick" star with a specified number of points.<br>
     * The parameters are the same as drawBurst, except there is an extra parameter at the end for the thickness. <br>
     * Precondition: points >= 2
     */
    public static void drawThickStar(Graphics g, int centerX, int centerY, int radius, int points, int thickness) {
        if (thickness < 2)
            thickness = 2;
        thickness--;
        int originalRadius = radius;
        for (int j = 1; j <= thickness; j++) {
            drawStar(g, centerX, centerY, radius, points);
            radius--;
        }
        centerX++;
        radius = originalRadius;
        for (int j = 1; j <= thickness; j++) {
            drawStar(g, centerX, centerY, radius, points);
            radius--;
        }
        centerY++;
        radius = originalRadius;
        for (int j = 1; j <= thickness; j++) {
            drawStar(g, centerX, centerY, radius, points);
            radius--;
        }
        centerX--;
        radius = originalRadius;
        for (int j = 1; j <= thickness; j++) {
            drawStar(g, centerX, centerY, radius, points);
            radius--;
        }
    }

    /**
     * Draws a certain number of "thick" lines in a burst like pattern.<br>
     * The parameters are the same as drawBurst, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickBurst(Graphics g, int centerX, int centerY, int radius, int numLines, int thickness) {
        if (thickness < 2)
            thickness = 2;
        double offSet;
        if (numLines % 2 == 1)
            offSet = halfPI;
        else
            offSet = halfPI + Math.PI / numLines;
        for (double radian = 0; radian < twoPI; radian += twoPI / numLines) {
            int x = (int) Math.round(Math.cos(radian - offSet) * radius) + centerX;
            int y = (int) Math.round(Math.sin(radian - offSet) * radius) + centerY;
            drawThickLine(g, centerX, centerY, x, y, thickness);
        }
    }

    /**
     * Draws a "thick" spiral. <br>
     * The parameters are the same as drawSpiral, except there is an extra parameter at the end for the thickness.
     */
    public static void drawThickSpiral(Graphics g, int centerX, int centerY, int maxRadius, double spacing, int thickness) {
        double spiralInc = spacing / (twoPI * 100);
        if (thickness < 2)
            thickness = 2;
        double spiralRadius = 0;
        double radian = 0;
        int dotRadius = thickness / 2;
        while (spiralRadius <= maxRadius) {
            int x = (int) Math.round(Math.cos(radian - halfPI) * spiralRadius) + centerX;
            int y = (int) Math.round(Math.sin(radian - halfPI) * spiralRadius) + centerY;
            fillCircle(g, x, y, dotRadius);
            radian += 0.01;
            spiralRadius += spiralInc;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Fill Methods

    /**
     * Draws a solid "filled in" rectangle.<br>
     * The upper-left-hand corner is specified by x1,y1 and the lower-right-hand corner is specified by x2, y2. <br>
     * Example: <br>
     * Grfx.fillRectangle(g,100,200,300,400); <br>
     * Draws an open rectangle whose upper-left-hand coordinate is (100,200) and whose lower-right-hand coordinate is (300,400).
     */
    public static void fillRectangle(Graphics g, int x1, int y1, int x2, int y2) {
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        g.fillRect(x1, y1, width, height);
    }

    /**
     * Draws a solid "filled in" rectangle with rounded corners. <br>
     * The parameters are the same as drawRoundedRectangle.
     */
    public static void fillRoundedRectangle(Graphics g, int x1, int y1, int x2, int y2, int pixels) {
        int temp;
        if (x1 > x2) {
            temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            temp = y1;
            y1 = y2;
            y2 = temp;
        }
        int width = x2 - x1 + 1;
        int height = y2 - y1 + 1;
        int diameter = pixels * 2;
        g.fillRoundRect(x1, y1, width, height, diameter, diameter);
    }

    /**
     * Draws a solid "filled in" circle.<br>
     * The user specifies the x,y coordinate of the center of the circle as well as the radius value. <br>
     * Example: <br>
     * Grfx.fillCircle(g,300,200,100); <br>
     * Draws a solid circle with a radius of 100 pixels whose center is located at the coordinate (300,200).
     */
    public static void fillCircle(Graphics g, int centerX, int centerY, int radius) {
        int diameter = 2 * radius;
        g.fillOval(centerX - radius, centerY - radius, diameter, diameter);
    }

    /**
     * Draws a solid "filled in" oval.<br>
     * The user specifies the x,y coordinate of the center of the circle as well as both radius values. <br>
     * Example: <br>
     * Grfx.fillCircle(g,300,200,100,50); <br>
     * Draws a solid circle with a horizontal radius of 100 pixels and a vertical radius of 50
     * whose center is located at the coordinate (300,200).
     */
    public static void fillOval(Graphics g, int centerX, int centerY, int hr, int vr) {
        int width = 2 * hr;
        int height = 2 * vr;
        g.fillOval(centerX - hr, centerY - vr, width, height);
    }

    /**
     * Draws a "solid" arc which will look either like a pie wedge or Pac-man.<br>
     * A FILLED ARC is a "piece" of a SOLID OVAL.<br>
     * The first 5 parameters (g and 4 ints) are the same as drawOval.<br>
     * There are 2 additional parameters for the starting degree value and finishing degree of the arc. <br>
     * 0 degrees is at the 12:00 position and the degrees progress in a CLOCKWISE fashion. <br>
     * (90 degrees is at 3:00, 180 degrees is at 6:00, 270 degrees is at 9:00, 360 degrees is back at 12:00).
     */
    public static void fillArc(Graphics g, int centerX, int centerY, int hRadius, int vRadius, int start, int finish) {
        int hDiameter = 2 * hRadius;
        int vDiameter = 2 * vRadius;
        if (finish < start)
            finish += 360;
        int newStart = 90 - start;   // shifts starting position from 3:00 to 12:00
        int newFinish = start - finish; // as oppose to finish-start.  Subtracting backwards changes from counter-clockwise to clockwise.

        g.fillArc(centerX - hRadius, centerY - vRadius, hDiameter, vDiameter, newStart, newFinish);
    }

    /**
     * Draws an solid "filled-in" irregular triangle using the three sets of provided coordinates. <br>
     * Example: <br>
     * Grfx.fillTriangle(g,100,300,200,100,300,300);
     */
    public static void fillTriangle(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon myPoly = new Polygon();
        myPoly.addPoint(x1, y1);
        myPoly.addPoint(x2, y2);
        myPoly.addPoint(x3, y3);
        g.fillPolygon(myPoly);
    }

    /**
     * Draws an solid "filled-in" irregular quadrilateral using the four sets of provided coordinates.  <br>
     * Example: <br>
     * Grfx.fillQuad(g,100,100,200,300,400,400,300,200);
     */
    public static void fillQuad(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Polygon myPoly = new Polygon();
        myPoly.addPoint(x1, y1);
        myPoly.addPoint(x2, y2);
        myPoly.addPoint(x3, y3);
        myPoly.addPoint(x4, y4);
        g.fillPolygon(myPoly);
    }

    /**
     * Draws an solid "filled-in" irregular polygon using 3 or more sets of provided coordinates. <br>
     * Examples: <br>
     * Grfx.fillPolygon(g,100,300,200,100,300,300);                         // for a triangle
     * Grfx.fillPolygon(g,525,300,600,250,650,250,725,300,725,350,650,400); // for a hexagon
     */
    public static void fillPolygon(Graphics g, int... coordinate) {
        if (coordinate.length < 6 || coordinate.length % 2 == 1) {
            int lineNumber = new Throwable().getStackTrace()[1].getLineNumber();
            throw new IllegalArgumentException("\nYou have " + coordinate.length +
                    " int parameters in your drawPolygon method call.\n" +
                    "When using fillPolygon, the number of int parameters must be even and no less than 6.");
        } else {
            Polygon myPoly = new Polygon();
            for (int j = 0; j < coordinate.length - 1; j += 2)
                myPoly.addPoint(coordinate[j], coordinate[j + 1]);
            g.fillPolygon(myPoly);
        }
    }

    public static void fillRegularPolygon(Graphics g, int centerX, int centerY, int radius, int sides) {
        int[] xCoord = new int[sides];
        int[] yCoord = new int[sides];
        double rotate;
        if (sides % 2 == 1)
            rotate = halfPI;
        else
            rotate = halfPI + Math.PI / sides;
        for (int k = 0; k < sides; k++) {
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k / sides - rotate) * radius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k / sides - rotate) * radius) + centerY;
        }
        if (sides == 3)
            yCoord[1] = yCoord[2];
        g.fillPolygon(xCoord, yCoord, sides);
    }

    /**
     * Draws a solid "filled in" star with a specified number of points.<br>
     * The center of this star is specified by centerX,centerY and its size is specified by radius <br>
     * (As in the radius of the circle the star would fit inside). <br>
     * Precondition: points >= 2 <br>
     * Example: <br>
     * Grfx.fillStar(g,300,200,100,8); <br>
     * Draws a solid star with 8 points and a radius of 100 pixels whose center is located at the coordinate (300,200).
     */
    public static void fillStar(Graphics g, int centerX, int centerY, int radius, int points) {
        int halfRadius = getHalfRadius(radius, points);
        int p = points;
        points *= 2;
        int[] xCoord = new int[points];
        int[] yCoord = new int[points];
        int currentRadius;
        for (int k = 0; k < points; k++) {
            if (k % 2 == 0)
                currentRadius = radius;
            else
                currentRadius = halfRadius;
            xCoord[k] = (int) Math.round(Math.cos(twoPI * k / points - halfPI) * currentRadius) + centerX;
            yCoord[k] = (int) Math.round(Math.sin(twoPI * k / points - halfPI) * currentRadius) + centerY;
        }
        int x = (p - 5) / 2 + 1;
        if (p >= 5 && p <= 51)
            switch (p % 4) {
                case 1:
                    yCoord[x] = yCoord[x + 1] = yCoord[points - x - 1] = yCoord[points - x];
                    break;
                case 2:
                    yCoord[x] = yCoord[x + 1] = yCoord[points - x - 1] = yCoord[points - x];
                    yCoord[x + 3] = yCoord[x + 4] = yCoord[points - x - 4] = yCoord[points - x - 3];
                    break;
                case 3:
                    yCoord[x + 2] = yCoord[x + 3] = yCoord[points - x - 3] = yCoord[points - x - 2];
            }
        g.fillPolygon(xCoord, yCoord, points);
    }

    ////////////////////////////////////////////////////////////////////////////////
    // Helper Method

    // used by drawStar, drawThickStar and fillStar
    private static int getHalfRadius(int radius, int points) {
        int halfRadius;

        switch (points) {
            case 3:
                halfRadius = 140 * radius / 500;
                break;
            case 4:
                halfRadius = 170 * radius / 400;
                break;
            case 5:
                halfRadius = 192 * radius / 500;
                break;
            case 6:
                halfRadius = 233 * radius / 400;
                break;
            case 7:
                halfRadius = 179 * radius / 500;
                break;
            case 8:
                halfRadius = 215 * radius / 400;
                break;
            case 9:
                halfRadius = 173 * radius / 500;
                break;
            case 10:
                halfRadius = 212 * radius / 400;
                break;
            default:
                if (points < 52) {
                    if (points % 2 == 1)
                        halfRadius = (180 - points) * radius / 500;
                    else
                        halfRadius = (222 - points) * radius / 400;
                } else
                    halfRadius = radius / 2;
        }
        return halfRadius;
    }
}
