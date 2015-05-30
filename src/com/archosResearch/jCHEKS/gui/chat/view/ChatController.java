package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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
    
    private final String remoteContact = "Bob"; //Hardcoded

    @FXML
    private void handleSendButton(){
        displayOwnMessage();
        resetInputField();
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