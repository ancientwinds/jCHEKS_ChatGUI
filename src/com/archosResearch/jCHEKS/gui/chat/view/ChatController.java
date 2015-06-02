package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.model.Message;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatController {

    @FXML
    private TextArea messageOutput; 
    @FXML
    private TextArea messageInput;
   
    @FXML
    private void handleSendButton(){
        JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.forwardOutgoingMessage(messageInput.getText());
        resetInputField();
    }
    
    @FXML
    private void handleAboutButton(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewController.class.getResource("About.fxml"));
            BorderPane aboutLayout = (BorderPane) loader.load();
            Scene scene = new Scene(aboutLayout);
            JavaFxViewController viewController = JavaFxViewController.getInstance();
            viewController.showScene(scene);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void displayOwnMessage(){
        messageOutput.appendText("You >> " + messageInput.getText() + "\n");
    }
    
    void displayMessage(Message message){
        messageOutput.appendText(message.getContent() + "\n");
    }
    
    private void resetInputField(){
        messageInput.setText("");
    }
}