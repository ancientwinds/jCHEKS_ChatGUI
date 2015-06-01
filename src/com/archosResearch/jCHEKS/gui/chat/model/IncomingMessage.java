package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class IncomingMessage extends Message{
    private String senderName;
    
    public IncomingMessage(String senderName, String content /*, EState state */){
        super(content);
        this.senderName = senderName;
    }
    
    @Override
    public String getContent(){
        return this.senderName + " said: "+ super.getContent();
    }
    public String getSenderName(){
        return this.senderName;
    }
}
