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
    private int width;
    private int height;
    private String randSeed;
    private String background;
    private Properties p;

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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getBackground() {
        return background;
    }

    public int getRandSeed() {
        if (randSeed.equals("auto"))
            randSeed = "0";
        return Integer.parseInt(randSeed);
    }

    public String getShapeDescription(String shapeName) {
        //получает "red_circle", даёт "svg.shape.RedCircle", оно как раз после shape.инпут=
        System.out.println(Integer.parseInt(p.getProperty("height", "500")));
        System.out.println(p.getProperty("shape." + shapeName));
        System.out.println("b");
        return p.getProperty("shape." + shapeName);
    }
}
