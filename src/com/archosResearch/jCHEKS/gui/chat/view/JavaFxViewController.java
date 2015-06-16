package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.engine.AbstractEngine;
import com.archosResearch.jCHEKS.concept.engine.message.*;
import com.archosResearch.jCHEKS.concept.ioManager.*;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class JavaFxViewController extends Application implements InputOutputManager {

    private static final CountDownLatch latch = new CountDownLatch(1);
    private static JavaFxViewController instance = null;
    private AbstractEngine engine;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ChatViewHandler chatViewHandler;

    /**
     * Should never be called. Call getInstance().
     */
    public JavaFxViewController() throws Exception {
        if (instance == null) setInstance(this);
        JavaFxViewController.class.getConstructor().setAccessible(false);
    }

    private static void setInstance(JavaFxViewController instance) {
        JavaFxViewController.instance = instance;
        latch.countDown();
    }

    public static JavaFxViewController getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }
    
    public void refresh(){
        Platform.runLater(() -> this.chatViewHandler.refreshMessage());
    }
    
    private static void createInstance(){
        try {
                Runnable launchJavaFx = () -> { javafx.application.Application.launch(JavaFxViewController.class); };
                new Thread(launchJavaFx).start();
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    
    @Override
    public void messageSent(OutgoingMessage message, String contactName) {
        chatViewHandler.displayOutgoingMessage(message);
    }

    @Override
    public void messageReceived(IncomingMessage message, String contactName) {
        chatViewHandler.displayIncomingMessage(message, contactName);
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
            loader.setLocation(ChatViewHandler.class.getResource("Chat.fxml"));
           
            this.rootLayout = (BorderPane) loader.load();
            this.chatViewHandler = loader.getController();
            Scene scene = new Scene(this.rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contactAdded(String contactName) {
        this.chatViewHandler.addPaneForContact(contactName);
    }

    @Override
    public void setEngine(AbstractEngine engine) {
        this.engine = engine;
    }

    @Override
    public void forwardOutgoingMessage(String messageContent, String contactName) {
        this.engine.handleOutgoingMessage(messageContent, contactName);
    }

    //Package private
    void openInBrowser(String url) {
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(url);
    }

    //Package private
    void addPopup(Scene popup, String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initOwner(this.primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(popup);
        stage.show();
    }
    
    //Package private
    Node loadFxml(String path) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(JavaFxViewController.class.getResource(path));
        return loader.load();
    }

    //Package private
    void sendNewContactRequest(ContactInfo contactInfo) {
        this.engine.createContact(contactInfo);
    }

    //Package private
    void setReceivingPort(int port) {
        this.engine.setReceivingPort(port);
    }
    
}
