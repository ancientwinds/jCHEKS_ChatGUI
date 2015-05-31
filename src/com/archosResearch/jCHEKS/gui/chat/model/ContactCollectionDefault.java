package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactCollectionDefault implements ContactCollection{

    private final ArrayList<Contact> contacts;

    public ContactCollectionDefault(ArrayList contacts) {
        this.contacts = contacts;
    }

    public Contact findByName(String aName) throws ContactNotFoundException {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(aName)) {
                return contact;
            }
        }
        throw new ContactNotFoundException();
    }

    public void add(Contact newContact) throws NameOfContactAlreadyExistInContactsException{
        for (Contact aContact : this.contacts) 
            if (aContact.getName().equals(newContact.getName())) throw new NameOfContactAlreadyExistInContactsException();
        this.contacts.add(newContact);
    }

}
