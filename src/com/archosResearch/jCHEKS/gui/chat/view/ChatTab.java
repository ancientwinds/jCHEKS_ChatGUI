package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.scene.control.*;
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

        outputField = new TextArea();
        outputField.setEditable(false);
        mainContainer.getChildren().add(outputField);
        
        inputField = new TextField();
        inputField.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                JavaFxViewController.getInstance().forwardOutgoingMessage(inputField.getText());
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
