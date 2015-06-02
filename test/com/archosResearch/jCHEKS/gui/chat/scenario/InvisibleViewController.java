package com.archosResearch.jCHEKS.gui.chat.scenario;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.OutgoingMessage;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class InvisibleViewController implements ViewController{
    AppController appController;
    ArrayList<Message> messagesToSend;
    ArrayList<Message> receivedMessages;
    ArrayList<Message> expectedMessagesToReceive;
    Contact contact;
    
    public InvisibleViewController(/*ArrayList expectedMessagesToReceive, ArrayList messagesToSend*/){
        /*this.expectedMessagesToReceive = expectedMessagesToReceive;
        this.messagesToSend = messagesToSend;
        this.receivedMessages = new ArrayList();*/
        
    }
    
    @Override
    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @Override
    public void messageSent(OutgoingMessage message, Contact contact) {
        System.out.println("Message from " + message.getContent());
    }

    @Override
    public void messageReceived(IncomingMessage message, Contact contact) {
        System.out.println("Message from " + message.getContent());
        //this.receivedMessages.add(message);
    }

    @Override
    public void contactAdded(Contact contact) {
    }
    
    
    public boolean workAsExpected(){
        return this.expectedMessagesToReceive.equals(this.receivedMessages);
    }

    @Override
    public void forwardOutgoingMessage(String messageContent) {
        this.appController.handleOutgoingMessage(messageContent, this.contact);
    }

    @Override
    public void setSelectedContact(Contact contact) {
        this.contact = contact;
    }
}
