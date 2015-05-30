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

    public Model() {
        this.contactCollection = new ContactCollection();
        this.map = new HashMap<>();
    }

    public void addContact(String contactName) {
        try {
            this.contactCollection.add(new Contact(contactName));
            this.map.put(new Contact(contactName), new MessageCollection());
        } catch (ContactAlreadyExistException e) {
            e.printStackTrace();
        } catch (NameOfContactAlreadyExistInContactsException e) {
            e.printStackTrace();
        }
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
