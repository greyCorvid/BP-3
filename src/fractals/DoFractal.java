package fractals;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DoFractal extends Application{

    private WritableImage wi;

    @Override
    public void start(Stage primaryStage) {
        //чтобы окно очень маленьким не было
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(225);

        primaryStage.setTitle("Fractals!!!");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        VBox root = new VBox();
        wi = new WritableImage(400, 400);
        ImageView iv = new ImageView(wi);

        root.setBackground(new Background(
                new BackgroundFill(Color.BLANCHEDALMOND, null, null)
        ));

        root.getChildren().add(iv);
        return root;
    }

    private void initInteraction() {
//        Fractal f = new CircleFractal();
//        Palette p = new BlackWhitePalette();

//        Fractal f = new CircleGrayscaleFractal();
//        Palette p = new GraysPalette();

        Fractal f = new CircleGrayscaleFractal2();
        Palette p = new GraysPalette();
        drawOnAllPixels(f, p, wi, -3, 3, 6./400);
    }

    private static void drawOnAllPixels(Fractal fractal, Palette palette, WritableImage wi, double x0, double y0, double dx) {
        PixelWriter pw = wi.getPixelWriter();
        //x0, y0 - координаты верхнего левого угла картинки в математической системе.
        //x1, y1 - координаты по wi
        //dx - размер пикселя в мат. системе
        for (int x1 = 0; x1 < wi.getWidth(); x1++) {
            for (int y1 = 0; y1 < wi.getHeight(); y1++) {
                double x = x0 + x1*dx;
                double y = y0 - y1*dx;
                double colorInd = fractal.getColorIndex(x,y);
                Color color = palette.getColor(colorInd);
                pw.setColor(x1,y1,color);
            }
        }
    }
}
