package com.archosResearch.jCHEKS.gui.chat.model;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactCollection {
    private final ArrayList<Contact> contacts;
    
    public ContactCollection(Contact... contacts) {
        this.contacts = new ArrayList<>();
        this.contacts.addAll(Arrays.asList(contacts));
    }
    
    public Contact findByName(String aName) throws ContactNotFoundException{
        for(Contact contact: this.contacts){
            if(contact.getName().equals(aName)){ return contact;}
        }  
        throw new ContactNotFoundException();
    }
    
}
