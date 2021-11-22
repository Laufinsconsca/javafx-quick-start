package ui.warnings;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class WarningWindows {

    private static final Map<Alert.AlertType, String> messageTypeToTitleMap =
            Map.of(Alert.AlertType.WARNING, "Warning", Alert.AlertType.INFORMATION, "Information");

    public static void showError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error alert");
        alert.setHeaderText(e.getMessage());
        VBox dialogPaneContent = new VBox();
        Label label = new Label("Stack trace:");
        String stackTrace = getStackTrace(e);
        TextArea textArea = new TextArea();
        textArea.setText(stackTrace);
        dialogPaneContent.getChildren().addAll(label, textArea);
        alert.getDialogPane().setContent(dialogPaneContent);
        alert.showAndWait();
    }

    private static String getStackTrace(Exception e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static void doOperation(String message, Alert.AlertType messageType) {
        Alert alert = new Alert(messageType);
        alert.setTitle(messageTypeToTitleMap.get(messageType));
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWarning(String message) {
        doOperation(message, Alert.AlertType.WARNING);
    }

    public static void showNotification(String message) {
        doOperation(message, Alert.AlertType.INFORMATION);
    }
}
