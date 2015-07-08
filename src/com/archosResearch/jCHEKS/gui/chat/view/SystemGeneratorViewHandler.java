package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.chaoticSystem.*;
import java.io.File;
import java.util.Random;
import java.util.logging.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.*;

/**
 *
 * @author thomas
 */
public class SystemGeneratorViewHandler {
    
    @FXML
    private TextField keyLengthField;
    @FXML
    private TextField systemIdField;    
    @FXML
    private TextField seedField;
    @FXML
    private Button createSystemButton;
    
    @FXML
    private void handleCreateAndSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Location.");
        
        File selectedFile = fileChooser.showSaveDialog((Stage) keyLengthField.getScene().getWindow());
        if (selectedFile != null) {
            try {
                ChaoticSystem chaoticSystem;
                if(seedField.getText().length() > 0) {
                    chaoticSystem = new ChaoticSystem(Integer.parseInt(keyLengthField.getText()), new Random(seedField.getText().hashCode()));
                } else {
                    chaoticSystem = new ChaoticSystem(Integer.parseInt(keyLengthField.getText()), systemIdField.getText());
                }                
                FileReader.saveChaoticSystem(selectedFile.getName(), chaoticSystem);
                
                Stage stage = (Stage) keyLengthField.getScene().getWindow();
                stage.close();
            } catch (Exception ex) {
                Logger.getLogger(SystemGeneratorViewHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    private void validate() {
        boolean keyLenghtIsValid = !keyLengthField.getText().isEmpty() & keyLengthField.getText().matches("^[0-9]*$");
        boolean keyPlusIdIsValdid =  !systemIdField.getText().isEmpty() & keyLenghtIsValid;
        boolean keyPlusSeedIsValdid =  !seedField.getText().isEmpty() & keyLenghtIsValid;
        boolean buttonEnabled = keyPlusIdIsValdid || keyPlusSeedIsValdid;
        
        createSystemButton.setDisable(!buttonEnabled);
    }
    
    
}
