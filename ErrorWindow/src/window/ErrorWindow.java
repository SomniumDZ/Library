package window;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Throws errors/messages in new Window.
 *
 * Compatible only with JavaFX applications.
 * Compatibility with other types of Java applications is possible, but not tested.
 */
public abstract class ErrorWindow {
    private Stage window = new Stage();
    private Label message;
    private Button okButton;
    private VBox vBox;
    private BorderPane root;
    private Scene scene;

    //    default
    public void throwError() {
        throwError("Error", "Error");
    }

    protected ErrorWindow() {
        window.initModality(Modality.APPLICATION_MODAL);
        message = new Label();
        okButton = new Button("Ok");
        vBox = new VBox(5, message, okButton);
        vBox.setAlignment(Pos.CENTER);
        okButton.setOnAction(event -> window.close());
        vBox.setPadding(new Insets(5, 5, 5, 10));
        root = new BorderPane();
        root.setCenter(vBox);
        scene = new Scene(root);
    }

    //    standard
    public void throwError(String title, String text) {
        message.setText(text);
        window.setScene(scene);
        window.setTitle(title);
        window.showAndWait();
    }

    //    with addictive functionality
    void throwError(String title, String text, Button... addictiveFunctionality) {
        throwError("Not realized");
    }

    //    short
    public void throwError(String text) {
        throwError("Error", text);
    }

    public Label getMessage() {
        return message;
    }

    public Button getOkButton() {
        return okButton;
    }

    public VBox getvBox() {
        return vBox;
    }

    public BorderPane getRoot() {
        return root;
    }

    public Stage getWindow() {
        return window;
    }

    public Scene getScene() {
        return scene;
    }
}

