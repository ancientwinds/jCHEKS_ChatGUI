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
    //private final CHECKSEngine engine;
    
    public AppController(){
        this.model = new Model();
        this.viewController = ViewController.getInstance(this);
        this.model.addObserver(this.viewController);
        //this.engine = new CHECKSEngine
        
    }
    
    public void handleIncomingMessage(Message message){
        this.model.addIncomingMessage(message);
    }
    
    public void handleOutgoingMessage(Message message){
        this.model.addOutgoingMessage(message);
    }
    
    public static void main(String args[]){
        new AppController();
    }
}              