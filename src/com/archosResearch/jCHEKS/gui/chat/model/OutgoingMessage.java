package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class OutgoingMessage extends Message{
    
    //private EState state; (Enum of state)
    
    public OutgoingMessage(String content) {
        super(content);
    }
    
    @Override
    public String getContent(){
        return "I said: "+ super.getContent();
    }
    //public getState(){ return state; }
    
}