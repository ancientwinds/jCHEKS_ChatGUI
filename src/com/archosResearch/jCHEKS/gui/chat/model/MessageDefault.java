package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageDefault implements Message{
    private String content;
    private String senderName;
    //private EState state; (Enum of state)
    
    public MessageDefault(String senderName, String content /*, EState state */){
        this.senderName = senderName;
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getSenderName(){
        return this.senderName;
    }
}
