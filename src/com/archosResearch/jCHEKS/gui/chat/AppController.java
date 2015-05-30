package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.*;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppController {
    
    private final Model model;
    private final ViewController viewController;
    
    public AppController(){
        this.model = new Model();
        this.viewController = ViewController.getInstance(this);
        this.model.addObserver(this.viewController);
        //this.model.addContact();
    }
    
    public void handleIncomingMessage(Contact contact, Message message){
        this.model.addMessage(contact, message);
    }
    
    public static void main(String args[]){
        new AppController();
    }
}              