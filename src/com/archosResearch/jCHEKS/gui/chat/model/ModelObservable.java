package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ModelObservable{
    private final List<ModelObserver> observers;
    
    public ModelObservable(){
        this.observers  = new ArrayList<>();
    }
    public void addObserver(ModelObserver observer){
        this.observers.add(observer);
    }
    
    public void removeObserver(ModelObserver observer){
        this.observers.remove(observer);
    }
    
    public void notifyNewMessageSent(Contact contact, Message message){
        for (ModelObserver observer : observers) {
            observer.newMessageSent(contact, message);
        }
    }
    
    public void notifyNewMessageReceived(Message message){
        for (ModelObserver observer : observers) {
            observer.newMessageReceived(message);
        }
    }
    
}