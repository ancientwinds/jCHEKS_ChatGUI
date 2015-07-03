package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.chaoticSystem.ChaoticSystem;
import com.archosResearch.jCHEKS.chaoticSystem.FileReader;
import com.archosResearch.jCHEKS.concept.chaoticSystem.AbstractChaoticSystem;
import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import java.io.File;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
                ChaoticSystem chaoticSystem = new ChaoticSystem(Integer.parseInt(keyLengthField.getText()));
                
                fileReader.saveChaoticSystem(selectedFile.getName(), chaoticSystem);
                
                Stage stage = (Stage) keyLengthField.getScene().getWindow();
                stage.close();
            } catch (Exception ex) {
                Logger.getLogger(SystemGeneratorViewHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
