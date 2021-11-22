package ui;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public abstract class ParentWindow extends Window implements Initializable {
    private final Map<String, Window> controllerMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Initializer.initializeWindowControllers(this.getClass(), getStage(), controllerMap);
    }

    protected Window getController(String path) {
        return controllerMap.get(path + ".fxml");
    }

    private void open(StackTraceElement stackTraceElement) {
        Stage stage = getController(stackTraceElement.getMethodName()).getStage();
        stage.show();
    }

    /**
     * The methods below can only be called in a method that has the same name as the FXML file of the window you want to open
     */

    protected void open() {
        open(Thread.currentThread().getStackTrace()[2]);
    }

    protected void openWithCallback(Consumer<Object> callback) {
        Window window = getController(Thread.currentThread().getStackTrace()[2].getMethodName());
        window.setCallback(callback);
        window.getStage().show();
    }

    protected Window getController() {
        return getController(Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
