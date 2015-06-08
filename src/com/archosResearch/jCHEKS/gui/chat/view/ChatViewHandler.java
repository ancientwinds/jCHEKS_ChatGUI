package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.ioManager.InputOutputManager;
import com.archosResearch.jCHEKS.concept.engine.message.IncomingMessage;
import com.archosResearch.jCHEKS.concept.engine.message.OutgoingMessage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatViewHandler {

    @FXML
    private TextArea messageOutput;
    @FXML
    private TextArea messageInput;

    @FXML
    private void handleSendButton() {
        JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.forwardOutgoingMessage(messageInput.getText());
        resetInputField();
    }

    @FXML
    private void handleAboutButton() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(InputOutputManager.class.getResource("About.fxml"));
            BorderPane aboutLayout = (BorderPane) loader.load();
            Scene scene = new Scene(aboutLayout);
            JavaFxViewController viewController = JavaFxViewController.getInstance();
            viewController.showScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayOutgoingMessage(OutgoingMessage message) {
        messageOutput.appendText("I said: " + message.getContent() + "\n");
    }

    void displayIncomingMessage(IncomingMessage message, String contactName) {
        messageOutput.appendText(contactName + " said: " + message.getContent() + "\n");
    }

    private void resetInputField() {
        messageInput.setText("");
    }
}
