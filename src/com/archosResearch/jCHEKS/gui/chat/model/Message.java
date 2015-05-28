package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Message {
    private String content;
    private Contact sender;
    //private EState state; (Enum of state)
    
    public Message(Contact sender, String content /*, EState state */){
        this.sender = sender;
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getSenderName(){
        return this.sender.getName();
    }
}
