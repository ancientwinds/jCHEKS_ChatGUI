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
        this.contactCollection.add(new Contact(contactName));
        this.map.put(new Contact(contactName), new MessageCollectionDefault(new ArrayList()));
    }

    public void addIncomingMessage(String messageContent, String contactName) {
        try {
            Contact contact = contactCollection.findByName(contactName);
            MessageCollection messageCollection = this.map.get(contact);
            messageCollection.addMessage(new Message("Me", messageContent));
        } catch (ContactNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void addOutgoingMessage(String messageContent, String contactName) {
        try {
            Contact contact = contactCollection.findByName(contactName);
            MessageCollection messageCollection = this.map.get(contact);
            messageCollection.addMessage(new Message(contact.getName(), messageContent));
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
