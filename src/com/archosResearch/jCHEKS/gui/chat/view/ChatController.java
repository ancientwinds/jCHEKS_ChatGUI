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
public class ChatController extends Application implements ModelObserver{
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static ChatController instance = null;
    private AppController appController;
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @FXML
    private TextArea messageOutput;
    
    @FXML
    private TextArea messageInput;
    
    private final String remoteContact = "Bob"; //Hardcoded
    
    public ChatController(){
        setInstance(this);
    }
    
    private static void setInstance(ChatController instance){
        ChatController.instance = instance;
        latch.countDown();
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat");
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
 
    public static ChatController getInstance(AppController appController){
        try{
            latch.await();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        instance.appController = appController;
        return instance;
    }

    @Override
    public void newMessageSent(Contact contact, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newMessageReceived(Message message) {
        this.displayMessage(message);    
    }
}