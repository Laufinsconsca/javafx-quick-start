package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.ParentWindow;
import ui.AutoInitializableController;

@AutoInitializableController(title = "The second window", pathFXML = "secondWindow.fxml")
public class SecondWindowController extends ParentWindow {
    @FXML
    private Label label;
    @FXML
    private Button button;

    @FXML
    private void thirdWindow() {
        openWithCallback(s -> {
            label.setText((String) s);
            button.setVisible(false);
        });
    }
}
