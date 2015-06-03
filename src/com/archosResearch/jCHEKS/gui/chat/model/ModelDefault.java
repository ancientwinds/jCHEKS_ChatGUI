package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ModelDefault extends ModelObservableDefault implements Model {

    private final ContactCollection contactCollection;
    private final HashMap<Contact, MessageCollection> map;

    public ModelDefault(ContactCollection contactCollection) {
        this.contactCollection = contactCollection;
        this.map = new HashMap();
    }

    @Override
    public void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException {
        this.contactCollection.add(contact);
        this.map.put(contact, new MessageCollectionDefault());
    }

    @Override
    public void addOutgoingMessage(String messageContent, Contact contact) {
        try {
            contactCollection.findByName(contact.getName());
            MessageCollection messageCollection = this.map.get(contact);
            OutgoingMessage message = new OutgoingMessage(messageContent);
            messageCollection.add(message);
            this.broadcastMessageSent(message, contact);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addIncomingMessage(String messageContent, Contact contact) {
        try {
            contactCollection.findByName(contact.getName());
            MessageCollection messageCollection = this.map.get(contact);
            IncomingMessage message = new IncomingMessage(messageContent);
            messageCollection.add(message);
            this.broadcastMessageReceived(message, contact);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Message> findMessagesByContact(String contactName) throws ContactNotFoundException {
        Contact contact = contactCollection.findByName(contactName);
        MessageCollection messageCollection = this.map.get(contact);
        return messageCollection.getAllMessages();
    }

}
