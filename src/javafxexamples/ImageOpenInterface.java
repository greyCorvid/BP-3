package javafxexamples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageOpenInterface extends Application{

    private VBox right;
    private ListView fileList;
    private HBox search;
    private TextField tf;
    private Button button;
    private Pane bg;
    private ImageView image;

    @Override
    public void start(Stage primaryStage) {
        //чтобы окно очень маленьким не было
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(225);

        primaryStage.setTitle("Viewing the image");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        initInteraction(); //метод для поведений элементов интерфейса, делаем чтоб разделять для удобства
        primaryStage.show();
    }

    private Parent initInterface() {
        SplitPane root = new SplitPane();
        fileList = new ListView();
        right = new VBox();

        search = new HBox();
        tf = new TextField();
        button = new Button("Обзор");

        bg = new Pane();
        image = new ImageView();

        HBox.setHgrow(search, Priority.ALWAYS);
        button.setMinWidth(80);


        root.getItems().addAll(fileList, right);
        right.getChildren().addAll(search, bg);
        search.getChildren().addAll(tf, button);
        bg.getChildren().addAll(image);
        return root;
    }

    private void initInteraction() {

    }
}
