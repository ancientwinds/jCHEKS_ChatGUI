package com.archosResearch.jCHEKS.gui.chat.model;

import com.archosResearch.jCHEKS.gui.chat.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.message.OutgoingMessage;
import java.util.HashMap;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Model extends AbstractModel {

    private final ContactCollection contactCollection;
    private final HashMap<Contact, MessageCollection> messages;

    public Model(ContactCollection contacts) {
        this.contactCollection = contacts;
        this.messages = new HashMap();
    }

    @Override
    public void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException {
        this.contactCollection.add(contact);
        this.messages.put(contact, new MessageCollectionDefault());
    }

    @Override
    public void addOutgoingMessage(String messageContent, Contact contact) {
        try {
            contactCollection.findByName(contact.getName());
            MessageCollection messageCollection = this.messages.get(contact);
            OutgoingMessage message = new OutgoingMessage(messageContent);
            messageCollection.add(message);
            this.notifyMessageSent(message, contact);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addIncomingMessage(String messageContent, Contact contact) {
        try {
            contactCollection.findByName(contact.getName());
            MessageCollection messageCollection = this.messages.get(contact);
            IncomingMessage message = new IncomingMessage(messageContent);
            messageCollection.add(message);
            this.notifyMessageReceived(message, contact);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    ///TODO AddMessage(AbstractMessage)
    
}
