package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private TextField uniqueId;
    
    @FXML
    private void handleCreateContact() {
        JavaFxViewController.getInstance().sendNewContactRequest(nameField.getText(), addressField.getText(), Integer.parseInt(portField.getText()), uniqueId.getText());
        Stage stage = (Stage) nameField.getScene().getWindow(); 
        stage.close();
    }

}
