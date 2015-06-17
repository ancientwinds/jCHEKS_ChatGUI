package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.engine.message.AbstractMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatTab extends Tab {

    TextField inputField;
    ListView<AbstractMessage> messagesListView;

    public ChatTab(String contactName) {
        super(contactName);
        this.messagesListView = createOutputNode();
        this.inputField = createInputNode();
        this.setContent(this.createChatContainer());
        this.setClosable(true);
    }

    public void handleMessage(AbstractMessage message) {
        Platform.runLater(() -> this.displayMessage(message));
    }
    private void displayMessage(AbstractMessage message){
        this.messagesListView.getItems().add(message);
        this.messagesListView.scrollTo(message);
    }
    
    private void resetInputField() {
        inputField.setText("");
    }
    
    public void refresh() {
        ObservableList<AbstractMessage> items = this.messagesListView.getItems();
        this.messagesListView.setItems(null);
        this.messagesListView.setItems(items);
    }
    
    private ListView<AbstractMessage> createOutputNode(){
        ListView<AbstractMessage> outputNode = new ListView();
        outputNode.setItems(FXCollections.<AbstractMessage>observableArrayList());
        outputNode.setCellFactory((ListView<AbstractMessage> param) -> new MessageListCell());
        return outputNode;
    }
    
    private TextField createInputNode(){
        TextField inputNode = new TextField();
        inputNode.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                JavaFxViewController.getInstance().forwardOutgoingMessage(inputField.getText(), this.getText());
                resetInputField();
            }
        });
        return inputNode;
    }
    
    private Node createChatContainer(){
        VBox chatContainer = new VBox();
        chatContainer.getChildren().add(this.messagesListView);
        chatContainer.getChildren().add(this.inputField);
        return chatContainer;
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
                switch (message.getState()) {
                    case FOR_ME:
                        src = "123.png";
                        break;
                    case WAITING_FOR_ACK:
                        src = "129.png";
                        break;
                    case WAITING_FOR_SECURE_ACK:
                        src = "128.png";
                        break;
                    case OK:
                        src = "121.png";
                        break;
                    case FAILED:
                        src = "127.png";
                        break;
                    default:
                        src = "127.png";
                }
                Image fxImage = new Image(JavaFxViewController.class.getResourceAsStream("res/img/" + src));
                ImageView imageView = new ImageView(fxImage);
                setGraphic(imageView);
                setText(message.getContent());
            }
        }
    }
}
