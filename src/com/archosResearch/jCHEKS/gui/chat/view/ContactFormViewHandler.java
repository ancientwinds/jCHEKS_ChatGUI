package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactFormViewHandler {

    @FXML
    private TextField nameField;
    
    @FXML
    private TextField addressField;
    
    @FXML
    private TextField portField;

    @FXML
    private void handleCreateContact() {
        JavaFxViewController.getInstance().sendNewContactRequest(nameField.getText(), addressField.getText(), portField.getText());
        Stage stage = (Stage) nameField.getScene().getWindow(); 
        stage.close();
    }

}
