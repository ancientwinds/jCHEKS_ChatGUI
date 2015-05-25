package com.archosResearch.jCHEKS.gui.chat;
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
public class ChatController extends Application{
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    @FXML
    private TextArea messageOutput;
    
    @FXML
    private TextArea messageInput;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ChatController.class.getResource("view/gui.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void handleSendButton(){
        messageOutput.appendText("You >> ");
        messageOutput.appendText(messageInput.getText() + "\n");
    }
    
}