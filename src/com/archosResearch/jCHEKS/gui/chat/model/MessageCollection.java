package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.Observable;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollection extends Observable{
    private final ArrayList<Message> messages;
    
    public MessageCollection(){
        this.messages = new ArrayList<>();
    }
    
    public void addMessage(Message aMessage){
        this.messages.add(aMessage);
        this.setChanged();
	this.notifyObservers(aMessage);
    }
    
    public ArrayList<Message> getAllMessages(){
        return this.messages;
    }

}
