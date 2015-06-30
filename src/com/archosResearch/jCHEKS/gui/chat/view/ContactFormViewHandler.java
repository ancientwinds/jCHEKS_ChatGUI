package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import java.io.File;
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
    private TextField inSysId;
    
    @FXML
    private TextField outSysId;

    @FXML
    private ChoiceBox encrypterField;

    @FXML
    private Button createContactButton;

    @FXML
    private void handleCreateContact() {
        ContactInfo contactInfo = new ContactInfo(addressField.getText(), Integer.parseInt(portField.getText()), nameField.getText(), "");
        JavaFxViewController.getInstance().sendNewContactRequest(contactInfo, true);
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }

    
    
    
    @FXML
    private void setInSysId(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select system file (in)");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Chaotic system files", "*.json", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog((Stage) nameField.getScene().getWindow());
        if (selectedFile != null) {
            inSysId.setText(selectedFile.getAbsolutePath());
            validate();
        }
    }

    @FXML
    private void setOutSysId(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select system file (out)");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Chaotic system files", "*.json", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog((Stage) nameField.getScene().getWindow());
        if (selectedFile != null) {
            outSysId.setText(selectedFile.getAbsolutePath());
            validate();
        }
    }
    
    @FXML
    private void validate() {
        boolean ipIsValid = addressField.getText().matches("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        boolean portIsValid = portField.getText().matches("^0*(?:6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{1,3}|[0-9])$");
        boolean fieldsNotEmpty = !nameField.getText().isEmpty() & !inSysId.getText().isEmpty() & !outSysId.getText().isEmpty();
        addressField.setStyle(getValidationStyle(ipIsValid));
        portField.setStyle(getValidationStyle(portIsValid));
        createContactButton.setDisable(!(ipIsValid & portIsValid & fieldsNotEmpty));
    }
    
    private String getValidationStyle(boolean isValid){
        return "-fx-control-inner-background: " + (isValid ? "white;" : "#FFC2C2;");
    }
}
