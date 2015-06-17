package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import com.archosResearch.jCHEKS.gui.chat.filemanager.FileManager;
import java.io.File;
import java.util.HashSet;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
    private SpecificTextField portField;

    @FXML
    private TextField uniqueId;
    
    @FXML
    private ChoiceBox encrypterField;
    
    @FXML
    private void handleCreateContact() {
        ContactInfo contactInfo = new ContactInfo(addressField.getText(), Integer.parseInt(portField.getText()), nameField.getText(), uniqueId.getText());
        JavaFxViewController.getInstance().sendNewContactRequest(contactInfo);
        Stage stage = (Stage) nameField.getScene().getWindow(); 
        stage.close();
    }
    
    @FXML
    private void handleSelectFile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load contact list.");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Json Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog((Stage) nameField.getScene().getWindow());
        if (selectedFile != null) {
           FileManager fileManager = new FileManager();
           HashSet<ContactInfo> contactsInfo = fileManager.loadContacts(selectedFile);
           JavaFxViewController controller = JavaFxViewController.getInstance();
           for (ContactInfo contactInfo : contactsInfo) {
                controller.sendNewContactRequest(contactInfo);
           }
        }
    }

}
