package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Model extends ModelObservable {

    private final ContactCollection contactCollection;
    private final HashMap<Contact, MessageCollection> map;

    public Model(ContactCollection contactCollection, HashMap map, ArrayList<ModelObserver> observers) {
        super(observers);
        this.contactCollection = contactCollection;
        this.map = map;
    }

    public void addContact(String contactName) throws NameOfContactAlreadyExistInContactsException{
        this.contactCollection.add(new Contact(contactName));
        this.map.put(new Contact(contactName), new MessageCollection(new ArrayList()));
    }

    public void addIncomingMessage(Message message) {
        try {
            Contact contact = contactCollection.findByName(message.getSenderName());
            MessageCollection messageCollection = this.map.get(contact);
            messageCollection.addMessage(new Message("Me", message.getContent()));
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void addOutgoingMessage(Message message) {
        try {
            Contact contact = contactCollection.findByName(message.getSenderName());
            MessageCollection messageCollection = this.map.get(contact);
            messageCollection.addMessage(new Message(contact.getName(), message.getContent()));
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
