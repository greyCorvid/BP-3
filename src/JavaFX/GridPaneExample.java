package JavaFX;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneExample extends Application{
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Different Panes");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() {
        //реализуем интерфейс мессенджера с помощью GridPaneExample (который в Panes сделали)
        GridPane root = new GridPane();

        TextArea history = new TextArea();
        TextField message = new TextField();
        Button send = new Button("Send");
        Label contactLabel = new Label("Контакты");
        ListView<String> contacts = new ListView<>();

        //можно constraint указать традиционно
        GridPane.setColumnIndex(history, 0);
        //в каком столбце поставить элемент
        GridPane.setRowIndex(history, 0);
        GridPane.setColumnSpan(history, 2);
        //сколько столбцов занимает
        GridPane.setRowSpan(history, 2);
        root.getChildren().add(history);

        //можно проще
        root.add(message, 0, 2);
        //что и где
        root.add(send, 1, 2);
        root.add(contactLabel, 2, 0);
        root.add(contacts, 2, 1, 1,2);
        //для контактс дополнительно указали колко строк и столбцов что занимает

        //Заставим элементы расстягиваться
        //Нужно казывать, как растягиваются строки и столбцы
        //рястянем первый столбец и вторую строку для наших целей
        ColumnConstraints cc0 = new ColumnConstraints();
        cc0.setHgrow(Priority.ALWAYS);

        RowConstraints rc0 = new RowConstraints();
        RowConstraints rc1 = new RowConstraints();
        rc1.setVgrow(Priority.ALWAYS);
        //Есть много других полезных ограничений
        //колумн роу констрейнтс - изначально пустые списки.
        //Чтобы ограничить вторую строку, нужно сделать первый пустой просто

        root.getColumnConstraints().add(cc0);
        root.getRowConstraints().addAll(rc0, rc1);

        //Список контактовнужно сделать не очень высоким,
        //а то последняя строка тоже становится высокой
        contacts.setPrefSize(200, 0);

        return root;
    }
}

