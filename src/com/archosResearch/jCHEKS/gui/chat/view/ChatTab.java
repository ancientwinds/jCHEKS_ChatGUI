package com.archosResearch.jCHEKS.gui.chat.view;

import java.awt.Image;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatTab extends Tab{
    
    TextField inputField;
    TextArea outputField;

    
    public ChatTab(String contactName){
        super(contactName);
        VBox mainContainer = new VBox();
        /*ListView<String> list = new ListView();
        
        
        ObservableList<String> data = FXCollections.observableArrayList(
            "a.msg", "a1.msg", "b.txt", "c.pdf", 
            "d.html", "e.png", "f.zip",
            "g.docx", "h.xlsx", "i.pptx");
                list.setItems(data);

        list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new AttachmentListCell();
            }
        });
        
        private static class AttachmentListCell extends ListCell<String> {
            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                    setText(null);
                } else {
                    Image fxImage = ;
                    ImageView imageView = new ImageView(fxImage);
                    setGraphic(imageView);
                    setText(item);
                }
            }
        }
        */
        outputField = new TextArea();
        outputField.setEditable(false);
        mainContainer.getChildren().add(outputField);
        
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
    
    public void displayMessage(String message){
        outputField.appendText(message+"\n");
    }
    
    public void resetInputField(){
        inputField.setText("");
    }
    
}
