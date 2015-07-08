package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.chaoticSystem.*;
import java.io.File;
import java.util.Random;
import java.util.logging.*;
import javafx.fxml.FXML;
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
    
}
