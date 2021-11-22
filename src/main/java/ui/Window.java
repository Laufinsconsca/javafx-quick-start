package ui;

import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

@Getter
@Setter
public abstract class Window {
    private Stage stage;
    private Consumer<Object> callback;
}
