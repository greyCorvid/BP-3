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

    private static WritableImage wi;
    private static Fractal f;
    private static Palette p;
    private static int wiW;
    private static int wiH;
    private static ImageView iv;
    private static VBox root;

    @Override
    public void start(Stage primaryStage) {
        //чтобы окно очень маленьким не было
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);

        primaryStage.setTitle("Fractals!!!");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction();
        primaryStage.show();

        //TODO изменение размера окна
        primaryStage.widthProperty().addListener(
                prop -> {
                    wiW = (int) primaryStage.getWidth();
                    pasteNewImage();
                }
        );
        primaryStage.heightProperty().addListener(
                prop -> {
                    wiH = (int) primaryStage.getHeight();
                    pasteNewImage();
                }
        );
    }

    private Parent initInterface() {
        root = new VBox();
        wiW = 400;
        wiH = 400;
        wi = new WritableImage(wiW, wiH);
        iv = new ImageView(wi);

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

//        Fractal f = new CircleGrayscaleFractal2();
//        Palette p = new GraysPalette();

//        Fractal f = new MandelbrotFractal();
//        Palette p = new GraysPalette();

        f = new MandelbrotFractal();
        p = new HsbPalette();
        drawOnAllPixels(f, p, wi, -0.6, 0.6, 6./20000);




        //TODO Добавить движение стрелочками
        //При нажатии на стрелочку налево сдвигаем x0 на 1/4 картинки,
            // это 100 пикселей в 400 картинке,100 пикселей именно в dx


        //TODO Масштаб
        //Умножение dx в полтора раза при приближении

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
                double colorInd = fractal.getColorIndex(x, y);
                Color color = palette.getColor(colorInd);
                pw.setColor(x1,y1,color);
            }
        }
    }

    private static void pasteNewImage() {
        wi = new WritableImage(wiW, wiH);
        iv = new ImageView(wi);
        root.getChildren().removeAll();
        root.getChildren().add(iv);
        drawOnAllPixels(f, p, wi, -0.6, 0.6, 6./20000);
    }
}
