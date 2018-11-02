package javafxexamples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageOpenInterface extends Application{
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
        ListView fileList = new ListView();
        VBox right = new VBox();

        root.getItems().addAll(fileList, right);
        return root;
    }

    private void initInteraction() {

    }
}
