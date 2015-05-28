package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import java.util.Observer;
import java.util.Observable;
import java.io.IOException;
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
public class ChatController extends Application implements Observer{
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AppController appController;
    @FXML
    private TextArea messageOutput;
    
    @FXML
    private TextArea messageInput;
    
    /**
     * HARDCODED VALUES
     */
    private final Contact ME = new Contact("Alice");
    private final Contact HIM = new Contact("Bob");

    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat");
        this.appController = new AppController();
        initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ChatController.class.getResource("gui.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void handleSendButton(){
        displayOwnMessage();
        resetInputField();
    }
    
    private void displayOwnMessage(){
        messageOutput.appendText("You >> " + messageInput.getText() + "\n");
    }
    
    private void displayMessage(Message aMessage){
        messageOutput.appendText(aMessage.getSenderName() + " >> " + aMessage.getContent() + "\n");
    }
    
    private void resetInputField(){
        messageInput.setText("");
    }
    
    @Override
    public void update(Observable aMessageCollection, Object aMessage) {
        this.displayMessage((Message)aMessage);
    }
}