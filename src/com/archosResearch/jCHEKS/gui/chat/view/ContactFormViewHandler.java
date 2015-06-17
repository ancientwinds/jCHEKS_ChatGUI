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
    private Button createContactButton;

    @FXML
    private void handleCreateContact() {
        ContactInfo contactInfo = new ContactInfo(addressField.getText(), Integer.parseInt(portField.getText()), nameField.getText(), uniqueId.getText());
        JavaFxViewController.getInstance().sendNewContactRequest(contactInfo);
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleSelectFile() {
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
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void validate() {
        boolean ipIsValid = addressField.getText().matches("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        boolean portIsValid = portField.getText().matches("^0*(?:6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{1,3}|[0-9])$");
        if (ipIsValid) {
            addressField.setStyle("-fx-text-inner-color: black;");
        } else {
            addressField.setStyle("-fx-text-inner-color: red;");
        }

        if (portIsValid) {
            portField.setStyle("-fx-text-inner-color: black;");
        } else {
            portField.setStyle("-fx-text-inner-color: red;");
        }
        if (ipIsValid & portIsValid) {
            createContactButton.setDisable(false);
        } else {
            createContactButton.setDisable(true);
        }
    }

}
