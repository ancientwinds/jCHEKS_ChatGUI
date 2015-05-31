package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.model.Message;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
        displayOwnMessage();
        resetInputField();
        
        JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.forwardOutgoingMessage(messageInput.getText(), "Bob");
    }
    
    private void displayOwnMessage(){
        messageOutput.appendText("You >> " + messageInput.getText() + "\n");
    }
    
    void displayMessage(Message aMessage){
        messageOutput.appendText(aMessage.getSenderName() + " >> " + aMessage.getContent() + "\n");
    }
    
    private void resetInputField(){
        messageInput.setText("");
    }
}