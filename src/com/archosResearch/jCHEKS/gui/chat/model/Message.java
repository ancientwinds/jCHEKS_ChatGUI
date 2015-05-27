package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Message {
    private final String content;
    private final Contact sender;
    //private EState state; (Enum of state)
    
    public Message(Contact aSender, String aContent /*, EState state */){
        this.sender = aSender;
        this.content = aContent;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getSenderName(){
        return this.sender.getName();
    }
}
