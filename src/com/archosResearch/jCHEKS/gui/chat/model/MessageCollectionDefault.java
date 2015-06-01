package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollectionDefault implements MessageCollection{
    private final ArrayList<Message> messages;
    
    public MessageCollectionDefault(ArrayList messages){
        this.messages = messages;
    }
    
    public void add(Message message){
        this.messages.add(message);
    }
    
    public ArrayList<Message> getAllMessages(){
        return this.messages;
    }

}
