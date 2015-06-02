package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ContactNotFoundException;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class FakeModelToTestAppController implements Model{

    public void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException{

    }

    public void addOutgoingMessage(String messageContent, String contactName) {

    }

    public void addIncomingMessage(String messageContent, String contactName) {

    }

    public ArrayList<Message> findMessagesByContact(String contactName) throws ContactNotFoundException {
        return null;
    }

    @Override
    public void addObserver(ModelObserver observer) {
        
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        
    }

    @Override
    public void broadcastMessageSent(Message message) {
        
    }

    @Override
    public void broadcastMessageReceived(Message message) {
        
    }

}
