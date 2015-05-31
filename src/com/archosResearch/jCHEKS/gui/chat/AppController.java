package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.*;
import com.archosResearch.jCHEKS.gui.chat.view.JavaFxViewController;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppController {
    
    private final Model model;
    private final ViewController viewController;
    //private final CHECKSEngine engine;
    
    public AppController(/*CHECKSEngine engine, */Model model, ViewController viewController){
        this.viewController = viewController;
        this.viewController.setAppController(this);
        //this.engine = engine;
        this.model = model;
        this.model.addObserver(this.viewController);
        //this.model.addObserver(engine);
    }
    
    public void handleIncomingMessage(Message message){
        this.model.addIncomingMessage(message);
    }
    
    public void handleOutgoingMessage(String messageContent, String contactName){
        this.model.addOutgoingMessage(messageContent, contactName);
    }
    
    public static void main(String args[]){
        new AppController(/* new CHECKSEngine(),*/new ModelDefault(new ContactCollectionDefault(new ArrayList()), new HashMap<>(), new ArrayList()), JavaFxViewController.getInstance());
    }
}              