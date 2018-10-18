package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PropertiesListenersAndBindings extends Application {
    //рефакторингом из инитинтерфейса сделали полями чтобы
    //в инитинтеракшене прописать всякое в ним же

    private TextField textField1;
    private Button button1;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Different Panes");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction(); //метод для поведений элементов интерфейса, делаем чтоб разделять для удобства
        primaryStage.show();
    }

    private Parent initInterface() {
        VBox root = new VBox();

        VBox example1 = new VBox();
        textField1 = new TextField();
        button1 = new Button("Пример 1");
        //имена давать осмысленные!! Тут 1 потому что пример 1
        example1.getChildren().addAll(textField1, button1);
        //Раскрасим панельку
        example1.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#FF0000"),
                                new CornerRadii(0), //закруглять не хотим
                                Insets.EMPTY //пустой паддинг
                        )
                )
        );
        example1.setStyle("-fx-background-color: #00FF00");
        //другой способ покороче пользуемся сиэсэс со стилями из жавафыкс

        root.getChildren().addAll(example1);
        return root;
    }


    private void initInteraction() {
        //-------------Пример 1-----------------
        //кнопочку учим делать всякое
        //универсальный но сложный способ:
        //В JavaFX реализована работа с событиями.
        //Разные объекты генерируют события
        //Можно добавлять слушателей(обработиков то есть хендлерво)
        //они реагируют на интересующие их события
        //Кнопка - ActionExent.ACTION в момент нажатия на кнопку
        //В принципе все ноды генерируют собития мыши там всякие
        //но тут неинтересно оно
        button1.addEventHandler(
                ActionEvent.ACTION, //какое событие кнопки интересует
                a -> System.out.println("pressed") // действие лямбда - выражение.
                // а - инфа о действии
                //в этой инфе можно найти источник событие.
                //Если бы было собитие от мыши
                //могли бы узнать положение курсоры
        );
        //-------------Пример 2-----------------
        //-------------Пример 3-----------------
        //-------------Пример 4-----------------
    }
}
