package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.engine.AbstractEngine;
import com.archosResearch.jCHEKS.concept.engine.message.*;
import com.archosResearch.jCHEKS.concept.ioManager.*;
import com.archosResearch.jCHEKS.gui.chat.view.exception.TabNotFoundException;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.*;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
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
    private String currentIp;
    private String currentName;
    private int receivingPort;

    /**
     * Should never be called. Call getInstance().
     */
    public JavaFxViewController() throws Exception {
        if (instance == null) {
            setInstance(this);
        }else{
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

    @Override
    public void log(String logMessage, String id) {
        this.chatViewHandler.log(logMessage, id);
    }

    @Override
    public void refresh() {
        Platform.runLater(() -> this.chatViewHandler.refreshMessage());
    }

    private static void createInstance() {
        try {
            Runnable launchJavaFx = () -> {
                javafx.application.Application.launch(JavaFxViewController.class);
            };
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
        try {
            chatViewHandler.displayIncomingMessage(message, contactName);
        } catch (TabNotFoundException ex) {
            Logger.getLogger(JavaFxViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Chat");
            initRootLayout();
            openConfigPopup();
        } catch (IOException ex) {
            Logger.getLogger(JavaFxViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void openConfigPopup() throws IOException {
        addPopup(new Scene((Pane) loadFxml("config.fxml"), 300, 200), "Configuration", true);
    }

    //Package private
    void openInBrowser(String url) {
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(url);
    }

    //Package private
    void addPopup(Scene popup, String title, boolean important) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initOwner(this.primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(popup);
        if (important) {
            stage.setOnCloseRequest((new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent arg) {
                    primaryStage.close();
                }
            }));
        }
        stage.show();
    }

    //Package private
    Node loadFxml(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(JavaFxViewController.class.getResource(path));
        return loader.load();
    }

    //Package private
    void sendNewContactRequest(ContactInfo contactInfo, boolean enableSameIp) {
        if (!contactInfo.getIp().equals(currentIp) | enableSameIp) {
            contactInfo.generateUniqueId(currentIp);
            contactInfo.generateChaoticSystemName(currentName);
            this.engine.createContact(contactInfo);
        }
    }

    //Package private
    void setIpAndPort(String name, String ip, int port) {
        this.currentIp = ip;
        this.receivingPort = port;
        this.currentName = name;
        this.engine.setReceivingPort(port);
        this.chatViewHandler.displayInfo(ip, port);
    }

}
