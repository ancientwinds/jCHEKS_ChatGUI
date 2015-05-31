package com.archosResearch.jCHECKS.gui.chat.scenario;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
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
    
    public InvisibleViewController(ArrayList expectedMessagesToReceive, ArrayList messagesToSend){
        this.expectedMessagesToReceive = expectedMessagesToReceive;
        this.receivedMessages = new ArrayList();
        this.messagesToSend = messagesToSend;
    }
    
    @Override
    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    @Override
    public void messageSent(Message message) {
        appController.handleOutgoingMessage(message);
    }

    @Override
    public void messageReceived(Message message) {
        
    }

    @Override
    public void addContact(Contact contact) {
    }
    
    public boolean workAsExpected(){
        return this.expectedMessagesToReceive.equals(this.receivedMessages);
    }
}
