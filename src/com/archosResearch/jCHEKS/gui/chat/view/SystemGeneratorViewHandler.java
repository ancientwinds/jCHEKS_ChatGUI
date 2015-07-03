package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.chaoticSystem.*;
import java.io.File;
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
    private void handleCreateAndSave() {
        System.out.println("gfdgfd");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Location.");
        
        File selectedFile = fileChooser.showSaveDialog((Stage) keyLengthField.getScene().getWindow());
        if (selectedFile != null) {
            try {
                FileReader fileReader = new FileReader();
                ChaoticSystem chaoticSystem = new ChaoticSystem(Integer.parseInt(keyLengthField.getText()), systemIdField.getText());
                
                fileReader.saveChaoticSystem(selectedFile.getName(), chaoticSystem);
                
                Stage stage = (Stage) keyLengthField.getScene().getWindow();
                stage.close();
            } catch (Exception ex) {
                Logger.getLogger(SystemGeneratorViewHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}