package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ConfigViewHandler {

    @FXML
    SpecificTextField ipAddressField;

    @FXML
    SpecificTextField portField;

    @FXML
    Button continueButton;

    @FXML
    private void validate() {
        boolean ipIsValid = ipAddressField.getText().matches("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        boolean portIsValid = portField.getText().matches("^0*(?:6553[0-5]|655[0-2][0-9]|65[0-4][0-9]{2}|6[0-4][0-9]{3}|[1-5][0-9]{4}|[1-9][0-9]{1,3}|[0-9])$");
        ipAddressField.setStyle(getValidationStyle(ipIsValid));
        portField.setStyle(getValidationStyle(portIsValid));
        continueButton.setDisable(!ipIsValid | !portIsValid);
    }
    
    private String getValidationStyle(boolean isValid){
        return "-fx-text-inner-color: " + (isValid ? "black;" : "red;");
    }
    
    @FXML
    private void handleContinueButton() {
        JavaFxViewController controller = JavaFxViewController.getInstance();
        controller.setIpAndPort(ipAddressField.getText(), Integer.parseInt(portField.getText()));
        Stage stage = (Stage) continueButton.getScene().getWindow();
        stage.close();
    }

}
