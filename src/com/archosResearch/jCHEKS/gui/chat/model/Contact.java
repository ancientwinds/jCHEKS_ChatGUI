/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Contact {
    private final String name;
    //private final int senderChaoticSystemId;
    //private final int receiverChaoticSystemId;
    //private final AbstractCommunicator communicator;
    //private final AbstractEncrypter encrypter;
    
    public Contact(String aName/*, int aSenderChaoticSystemId, int aReceiverChaoticSystemId*/){
        this.name = aName;
        //this.senderChaoticSystemId = aSenderChaoticSystemId;
        //this.receiverChaoticSystemId = aReceiverChaoticSystemId;
    }
    
    public String getName(){
        return this.name;
    }
}