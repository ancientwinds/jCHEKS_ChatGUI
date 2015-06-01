package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AboutController {

    @FXML
    private Button closeButton;
    
    @FXML
    private Hyperlink link;
   
    @FXML
    private void handleLinkClick(){
        JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.openInBrowser("http://www.archos-research.com/en/cheks.html");
    }
    
}