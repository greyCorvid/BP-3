package svg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class Settings {
    private static Settings instance = new Settings();
    private static int width;
    private static int height;
    private static String randSeed;
    private static String background;
    private static Properties p;

    public static Settings getInstance() {
        return instance;
    }

    private Settings() {
        Properties p = new Properties();
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"),
                    StandardCharsets.UTF_8)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        width = Integer.parseInt(p.getProperty("width", "500"));
        height = Integer.parseInt(p.getProperty("height", "500"));
        randSeed = p.getProperty("rand_seed", "0");
        background = p.getProperty("background", "#FFFFFF");
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static String getBackground() {
        return background;
    }

    public static int getRandSeed() {
        if (randSeed.equals("auto"))
            randSeed = "0";
        return Integer.parseInt(randSeed);
    }

    public static String getShapeDescription(String shapeName) {
        //получает "red_circle", даёт "svg.shape.RedCircle", оно как раз после shape.инпут=
        return p.getProperty("shape." + shapeName);
    }
}
