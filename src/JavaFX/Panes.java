package JavaFX;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Panes extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Different Panes");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox root = new HBox();
        VBox leftPane = new VBox();
        VBox rightPane = new VBox();
        TextField tf =  new TextField("");
        Button b = new Button("Send");
        Label l = new Label("Контакты");
        ListView lv = new ListView();

        root.getChildren().addAll(leftPane, rightPane);

        return root;
    }
}
