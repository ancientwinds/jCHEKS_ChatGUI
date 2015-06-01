package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ModelDefault extends ModelObservableDefault implements Model{

    private final ContactCollection contactCollection;
    private final HashMap<Contact, MessageCollection> map;

    public ModelDefault(ContactCollection contactCollection, HashMap map, ArrayList<ModelObserver> observers) {
        super(observers);
        this.contactCollection = contactCollection;
        this.map = map;
    }

    public void addContact(String contactName) throws NameOfContactAlreadyExistInContactsException{
        Contact contact = new Contact(contactName);
        this.contactCollection.add(contact);
        this.map.put(contact, new MessageCollectionDefault(new ArrayList()));
    }

    public void addOutgoingMessage(String messageContent, String contactName) {
        try {
            Contact contact = contactCollection.findByName(contactName);
            MessageCollection messageCollection = this.map.get(contact);
            Message message = new OutgoingMessage(messageContent);
            messageCollection.add(message);
            this.broadcastMessageReceived(message);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void addIncomingMessage(String messageContent, String contactName) {
        try {
            Contact contact = contactCollection.findByName(contactName);
            MessageCollection messageCollection = this.map.get(contact);
            Message message = new IncomingMessage(contactName, messageContent);
            messageCollection.add(message);
            this.broadcastMessageReceived(message);
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Message> findMessagesByContact(String contactName) throws ContactNotFoundException {
        Contact contact = contactCollection.findByName(contactName);
        MessageCollection messageCollection = this.map.get(contact);
        return messageCollection.getAllMessages();
    }

}