package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ViewController extends Application implements ModelObserver{
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static ViewController instance = null;
    private AppController appController;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ChatController chatController;
    
    public ViewController(){
        setInstance(this);
    }
    
    private static void setInstance(ViewController instance){
        ViewController.instance = instance;
        latch.countDown();
    }
    
    public static ViewController getInstance(AppController appController){
        if(instance == null){
            try{
                latch.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
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
        chatController.displayMessage(message);    
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
            loader.setLocation(ChatController.class.getResource("chat.fxml"));
            rootLayout = (BorderPane) loader.load();
             this.chatController = (ChatController) loader.getController();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
