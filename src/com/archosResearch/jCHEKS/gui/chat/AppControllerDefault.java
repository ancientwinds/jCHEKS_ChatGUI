package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.concept.engine.AbstractEngine;
import com.archosResearch.jCHEKS.gui.chat.model.*;
import com.archosResearch.jCHEKS.gui.chat.view.JavaFxViewController;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppControllerDefault implements AppController{
    
    private final Model model;
    private final ViewController viewController;
    //private final CHECKSEngine engine;
    
    public AppControllerDefault(AbstractEngine engine, Model model, ViewController viewController, String remoteContactName) throws NameOfContactAlreadyExistInContactsException{
        this.viewController = viewController;
        this.viewController.setAppController(this);
        //this.engine = engine;
        this.model = model;
        this.model.addContact(remoteContactName);
        this.model.addObserver(this.viewController);
        //this.model.addObserver(engine);
    }
    
    public void handleIncomingMessage(String messageContent, String contactName){
        this.model.addIncomingMessage(messageContent, contactName);
    }
    
    public void handleOutgoingMessage(String messageContent, String contactName){
        this.model.addOutgoingMessage(messageContent, contactName);
    }
}