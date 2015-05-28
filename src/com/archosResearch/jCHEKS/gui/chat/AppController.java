package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.*;
import com.archosResearch.jCHEKS.gui.chat.view.ChatController;
import com.archosResearch.jCHEKS.gui.chat.view.JavaFxLauncher;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppController {
    
    private Model model;
    private final ChatController chatController;
    
    public AppController(){
        this.model = new Model();
        this.chatController = ChatController.getInstance();
        this.model.addObserver(this.chatController);
        //this.model.addContact();
    }
    
    public void handleIncomingMessage(Contact contact, Message message){
        this.model.addMessage(contact, message);
    }
    
    public static void main(String args[]){
        new JavaFxLauncher();
        new AppController();
    }
}

                