package com.archosResearch.jCHEKS.gui.chat.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AboutViewHandler {

    @FXML
    private Button closeButton;

    @FXML
    private Hyperlink link;

    @FXML
    private void handleLink() {
        JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.openInBrowser("http://www.archos-research.com/en/cheks.html");
    }

}
