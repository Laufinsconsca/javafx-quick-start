package controllers;

import javafx.fxml.FXML;
import ui.AutoInitializableController;
import ui.Window;

@AutoInitializableController(title = "The third window", parentController = "SecondWindowController", pathFXML = "thirdWindow.fxml")
public class ThirdWindowController extends Window {

    @FXML
    private void setTextToSecondWindow() {
        getCallback().accept("Hello, JavaFX!");
        getStage().close();
    }
}
