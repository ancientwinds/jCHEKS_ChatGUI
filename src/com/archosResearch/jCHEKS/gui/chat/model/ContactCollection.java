package com.archosResearch.jCHEKS.gui.chat.model;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import java.util.ArrayList;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactCollection {
    private ArrayList<Contact> contacts;
    //TODO Resolve conflict between this two methods
    public ContactCollection(Contact... contacts) {
        this.contacts = new ArrayList<Contact>();
        for (Contact contact : contacts) {
            this.contacts.add(contact);
        }
    }/*
    public ContactCollection(Contact[] contacts) {
        this.contacts = new ArrayList<Contact>();
        for (Contact contact : contacts) {
            this.contacts.add(contact);
        }
    }
    */
    public Contact findByName(String aName) throws ContactNotFoundException{
        for(Contact contact: this.contacts){
            if(contact.getName().equals(aName)){ return contact;}
        }  
        throw new ContactNotFoundException();
    }
    
}
