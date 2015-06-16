package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.engine.message.AbstractMessage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.util.Callback;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatTab extends Tab{
    
    TextField inputField;
    ListView<AbstractMessage>  messagesListView;
    MessageListCell msgList;
    
    public ChatTab(String contactName){
        super(contactName);
        VBox mainContainer = new VBox();
        messagesListView = new ListView();
        
        ObservableList<AbstractMessage> data = FXCollections.observableArrayList();
        messagesListView.setItems(data);
        messagesListView.setCellFactory((ListView<AbstractMessage> param) -> new MessageListCell());
        
        mainContainer.getChildren().add(messagesListView);
        /*
        outputField = new TextArea();
        outputField.setEditable(false);
        mainContainer.getChildren().add(outputField);
        */
        
        inputField = new TextField();
        inputField.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                JavaFxViewController.getInstance().forwardOutgoingMessage(inputField.getText(), this.getText());
                resetInputField();
            }
        });
        
        mainContainer.getChildren().add(inputField);
        this.setContent(mainContainer);
        this.setClosable(true);
    }
    
    public void displayMessage(AbstractMessage message){
        Platform.runLater(() -> this.messagesListView.getItems().add(message));
        
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        message.setContent("Patate");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatTab.class.getName()).log(Level.SEVERE, null, ex);
        }
        message.setContent("poutine");*/
    }
    
    private void resetInputField(){
        inputField.setText("");
    }
    private static class MessageListCell extends ListCell<AbstractMessage> {
        
            @Override
            public void updateItem(AbstractMessage message, boolean empty) {
                super.updateItem(message, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    String src;
                    switch(message.getState()){
                        case FOR_ME:
                            src = "glyphicons-246-chat.png";
                            break;
                        default:
                            src = "glyphicons-83-roundabout.png";
                    }
                    Image fxImage = new Image(JavaFxViewController.class.getResourceAsStream(src));
                    ImageView imageView = new ImageView(fxImage);
                    setGraphic(imageView);
                    setText(message.getContent());
                }
            }
            
            /*@Override
            public void commitEdit(String newValue){
                Image fxImage = new Image("glyphicons-83-roundabout.png");
                ImageView imageView = new ImageView(fxImage);
                setGraphic(imageView);
            }*/
        }
    public void refresh(){
        ObservableList<AbstractMessage> items = this.messagesListView.getItems();
        this.messagesListView.setItems(null);
        this.messagesListView.setItems(items);
    }
}
