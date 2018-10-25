package JavaFX;
//Реализуйте программу,
// которая показывает на экране круг и
// дает возможность изменять его размер, цвет и т.п.
// Окно приложения разделено на две части,
// в левой части находятся элементы управления для выбора цветов и
// размеров круга, в правой части находится круг.
// Нужны следующие элементы управления:
// Slider для выбора радиуса круга,
// два ColorPicker для выбора цвета круга и цвета фона.
// Добавьте заодно метки с текстом, чтобы было понятно,
// где радиус, где цвет фона, где цвет круга.
//
//Начните с создания левой части интерфейса,
// добавьте на левую панель все элементы интерфейса.
//
//Наполните правую часть интерфейса,
// она должна состоять из панели Pane,
// которая будет являться фоном и, соответственно,
// раскрашиваться и отвечать за цвет фона.
// На панели должен лежать Circle.
// Это такой узел (Node),
// который изображается в виде круга указанного радиуса.

//Свяжите цвет из первого ColorPicker c цветом круга.

//Свяжите значение из Slider с радиусом круга.

//Свяжите цвет из второго ColorPicker c цветом фона.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//Свяжите координаты x и y круга с половиной, соответственно,
// ширины и высоты правой панели.
// Тем самым круг расположится ровно по центру панели.
//Свяжите максимальное значение слайдера выбора радиуса с
// максимально возможным радиусом круга,
// при котором круг все еще помещается на панель.
public class ColorfulCircle extends Application {

    private Circle circle;
    private Pane bg;
    private Slider slider;
    private ColorPicker color;
    private ColorPicker colorBg;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Color The Circle!");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction(); //метод для поведений элементов интерфейса, делаем чтоб разделять для удобства
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox root = new HBox();
        VBox left = new VBox();

        left.setMinWidth(300);


        //Left:
        Label sliderL = new Label("Choose size of the circle");
        Label colorBgL = new Label("Pick background color");
        Label colorL = new Label("Pick circle color");
        slider = new Slider();
        colorBg = new ColorPicker();
        color = new ColorPicker();
        color.setValue(Color.BLACK);

        //Right:
        bg = new Pane();
        circle = new Circle();
        bg.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#FF0000"),
                                new CornerRadii(0), //закруглять не хотим
                                Insets.EMPTY //пустой паддинг
                        )
                )
        );


        root.getChildren().addAll(left, bg);
        left.getChildren().addAll(sliderL, slider, colorBgL, colorBg, colorL, color);
        bg.getChildren().addAll(circle);

        left.setSpacing(5);
        HBox.setMargin(left,new Insets(5, 5, 5, 5));
        HBox.setMargin(bg,new Insets(5, 5, 5, 0));
        return root;
    }

    private void initInteraction() {
        circle.fillProperty().bind(color.valueProperty());
    }
}
