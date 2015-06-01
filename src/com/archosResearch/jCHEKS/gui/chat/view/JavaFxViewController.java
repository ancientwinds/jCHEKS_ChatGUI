package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
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
public class JavaFxViewController extends Application implements ViewController{
    private static final CountDownLatch latch = new CountDownLatch(1);
    private static JavaFxViewController instance = null;
    private AppController appController;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ChatController chatController;
    
    /**
     *  Should never be called. Call getInstance().
     */
    public JavaFxViewController() throws Exception{ 
        if(instance == null){
            setInstance(this);
        }
        else{
            //TODO Change exception type
            throw new Exception();
        }
    }
    
    private static void setInstance(JavaFxViewController instance){
        JavaFxViewController.instance = instance;
        latch.countDown();
    }
    
    public static JavaFxViewController getInstance(){
        if(instance == null){
            try{
                new Thread() {
                    @Override
                    public void run() {
                        javafx.application.Application.launch(JavaFxViewController.class);
                    }
                }.start();
                latch.await();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    @Override
    public void messageSent(Message message) {
        chatController.displayMessage(message);
    }

    @Override
    public void messageReceived(Message message) {
        chatController.displayMessage(message);    
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat");
        initRootLayout();
    }
    
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ViewController.class.getResource("Chat.fxml"));
            this.rootLayout = (BorderPane) loader.load();
            this.chatController = loader.getController();
            Scene scene = new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contactAdded(Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @Override
    public void forwardOutgoingMessage(String messageContent, String contactName) {
        this.appController.handleOutgoingMessage(messageContent, contactName);  
    }
    
    //Package private
    void openInBrowser(String url){
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(url);
    }
    
    //Package private
    void showScene(Scene scene){
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
}
