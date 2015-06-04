package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.engine.AbstractEngine;
import com.archosResearch.jCHEKS.concept.engine.message.IncomingMessage;
import com.archosResearch.jCHEKS.concept.engine.message.OutgoingMessage;
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
public class JavaFxViewController extends Application implements InputOutputManager {

    private static final CountDownLatch latch = new CountDownLatch(1);
    private static JavaFxViewController instance = null;
    private AbstractEngine engine;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ChatViewHandler chatController;
    private String selectedContactName;

    /**
     * Should never be called. Call getInstance().
     */
    public JavaFxViewController() throws Exception {
        if (instance == null) {
            setInstance(this);
        } else {
            //TODO Change exception type
            throw new Exception();
        }
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
        chatController.displayOutgoingMessage(message);
    }

    @Override
    public void messageReceived(IncomingMessage message, String contactName) {
        chatController.displayIncomingMessage(message, contactName);
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
            loader.setLocation(InputOutputManager.class.getResource("Chat.fxml"));
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
    public void contactAdded(String contactName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEngine(AbstractEngine engine) {
        this.engine = engine;
    }

    @Override
    public void forwardOutgoingMessage(String messageContent) {
        this.engine.handleOutgoingMessage(messageContent, this.selectedContactName);
    }

    //Package private
    void openInBrowser(String url) {
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(url);
    }

    //Package private
    void showScene(Scene scene) {
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    //TEMP
    @Override
    public void setSelectedContactName(String name) {
        this.selectedContactName = name;
    }
}
