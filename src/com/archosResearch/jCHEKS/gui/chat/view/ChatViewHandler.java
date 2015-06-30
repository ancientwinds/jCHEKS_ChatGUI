package com.archosResearch.jCHEKS.gui.chat.view;

import com.archosResearch.jCHEKS.gui.chat.view.exception.SelectedTabException;
import com.archosResearch.jCHEKS.gui.chat.view.exception.TabNotFoundException;
import com.archosResearch.jCHEKS.concept.engine.message.*;
import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import com.archosResearch.jCHEKS.gui.chat.filemanager.FileManager;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ChatViewHandler {

    private final JavaFxViewController mainController;

    private final HashMap<String, ChatTab> tabsMap = new HashMap();

    @FXML
    private MenuItem addContactButton;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Label infoLabel;

    public ChatViewHandler() {
        this.mainController = JavaFxViewController.getInstance();
    }

    @FXML
    private void handleAboutButton() {
        try {
            Pane aboutLayout = (Pane) this.mainController.loadFxml("About.fxml");
            aboutLayout.setPadding(new Insets(15));
            this.mainController.addPopup(new Scene(aboutLayout, 300, 200), "About", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNewContactButton() {
        try {
            Pane aboutLayout = (Pane) this.mainController.loadFxml("ContactForm.fxml");
            aboutLayout.setPadding(new Insets(15));
            this.mainController.addPopup(new Scene(aboutLayout), "Create new contact", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleSelectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load contact list.");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Json Files", "*.json"));
        File selectedFile = fileChooser.showOpenDialog((Stage) infoLabel.getScene().getWindow());
        if (selectedFile != null) {
            FileManager fileManager = new FileManager();
            HashSet<ContactInfo> contactsInfo = fileManager.loadContacts(selectedFile, mainController.getName());
            for (ContactInfo contactInfo : contactsInfo) {
                mainController.sendNewContactRequest(contactInfo, false);
            }
        }
    }
    private ChatTab getTabByName(String contactName) throws TabNotFoundException {
        ChatTab tab = tabsMap.get(contactName);
        if (tab != null) {
            return tab;
        }
        throw new TabNotFoundException("There is no tab associated with that name.");
    }

    private ChatTab getSelectedTab() throws Exception {
        Tab selectedTab = mainTabPane.getSelectionModel().getSelectedItem();
        if (selectedTab != null) {
            return (ChatTab) selectedTab;
        }
        throw new SelectedTabException("There is no currently selected tab.");
    }
    
    //Package private
    void displayOutgoingMessage(OutgoingMessage message) {
        try {
            getSelectedTab().handleMessage(message);
        } catch (Exception ex) {
            //TODO Change this and rethrow an exception.
            Logger.getLogger(ChatViewHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Package private
    void displayIncomingMessage(IncomingMessage message, String contactName) throws TabNotFoundException {
        getTabByName(contactName).handleMessage(message);
    }
    
    //Package private
    void displayInfo(String ip, int port) {
        infoLabel.setText("Your ip: " + ip + "        Receiving port:" + port);
    }

    //Package private
    void addPaneForContact(String contactName) {
        ChatTab tab = new ChatTab(contactName);
        this.tabsMap.putIfAbsent(contactName, tab);
        this.mainTabPane.getTabs().add(tab);
    }

    void log(String logMessage, String contactName) {
        try {
            this.getTabByName(contactName).log(logMessage);
        } catch (TabNotFoundException ex) {
            Logger.getLogger(ChatViewHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Package private
    void refreshMessage() {
        try {
            this.getSelectedTab().refresh();
        } catch (Exception ex) {
            Logger.getLogger(ChatViewHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
