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

    public Contact findByName(String aName) throws ContactNotFoundException {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(aName)) {
                return contact;
            }
        }
        throw new ContactNotFoundException();
    }

    void add(Contact newContact) throws ContactAlreadyExist, NameOfContactAlreadyExistInContacts {
        if (contacts.contains(newContact)) throw new ContactAlreadyExist();
        for (Contact aContact : this.contacts) 
            if (aContact.getName().equals(newContact.getName())) throw new NameOfContactAlreadyExistInContacts();
        this.contacts.add(newContact);
    }

}
