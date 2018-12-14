package fractals;

import javafx.scene.paint.Color;

public class HsbPalette implements Palette {
    @Override
    public Color getColor(double ind) {
        int hue = (int) (360 * ind);//1000 - N в мандельброте
        int satClass = (int) (ind * 1000) % 3; //1000 - N в мандельброте
        double sat = 1;
        if(satClass == 1) {
            sat = 0.9;
        } else if (satClass == 2) {
            sat = 0.8;
        }
        return Color.hsb(hue, sat, 1);
    }
}
