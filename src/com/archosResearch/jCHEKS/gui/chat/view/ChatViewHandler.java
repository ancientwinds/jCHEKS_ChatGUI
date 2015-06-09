package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.concept.ioManager.InputOutputManager;
import com.archosResearch.jCHEKS.concept.engine.message.*;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatViewHandler {
    
    private final JavaFxViewController mainController;
    
    
    HashMap<String, Tab> tabsMap = new HashMap();
    
    @FXML
    private MenuItem addContactButton;
    
    @FXML
    private TabPane mainTabPane;

    public ChatViewHandler(){
        this.mainController = JavaFxViewController.getInstance();
    }
    
    @FXML
    private void handleSendButton() {
        /*JavaFxViewController viewController = JavaFxViewController.getInstance();
        viewController.forwardOutgoingMessage(messageInput.getText());
        resetInputField();*/
    }

    @FXML
    private void handleAboutButton() {
        try {
            Pane aboutLayout = (Pane) this.mainController.loadFxml("About.fxml");
            aboutLayout.setPadding(new Insets(15));
            this.mainController.addPopup(new Scene(aboutLayout, 300, 200), "About");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        @FXML
    private void handleNewContactButton() {
        try {
            Pane aboutLayout = (Pane) this.mainController.loadFxml("ContactForm.fxml");
            aboutLayout.setPadding(new Insets(15));
            this.mainController.addPopup(new Scene(aboutLayout, 300, 200), "Create new contact");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void displayOutgoingMessage(OutgoingMessage message) {
        
        //messageOutput.appendText("I said: " + message.getContent() + "\n");
    }

    void displayIncomingMessage(IncomingMessage message, String contactName) {
        //messageOutput.appendText(contactName + " said: " + message.getContent() + "\n");
    }

    
    void addPaneForContact(String contactName){
        this.mainTabPane.getTabs().add(new ChatTab(contactName));
    }
    
    private Tab getSelectedTab() throws Exception{
        for(Tab tab : mainTabPane.getTabs()){
            if(tab.isSelected()){
                return tab;
            }
        }
        //TODO Create an exception for that.
        throw new Exception();
    }
    
    @FXML
    private void test_createTab() {
       addPaneForContact("Alice");
    }
    
    @FXML
    private void test_createTabGroups() {
       addPaneForContact("Alice");addPaneForContact("Bob");addPaneForContact("Tom");addPaneForContact("Pit");addPaneForContact("John");addPaneForContact("Nico");addPaneForContact("Ben");addPaneForContact("Nick");
    }
    
    @FXML
    private void test_deleteAllTab() throws Exception {
       mainTabPane.getTabs().clear();
    }
    
    @FXML
    private void test_invertSelTab(){
        try {
            Tab selectedTab = getSelectedTab();
            String txt = selectedTab.getText();
            selectedTab.setText(new StringBuilder(txt).reverse().toString());
        } catch (Exception ex) {}
    }
    
    @FXML
    private void test_write() {
        try {
            ChatTab tab = (ChatTab)getSelectedTab();
            tab.displayMessage("This is a test message!");
        } catch (Exception ex) {}
    }
}
