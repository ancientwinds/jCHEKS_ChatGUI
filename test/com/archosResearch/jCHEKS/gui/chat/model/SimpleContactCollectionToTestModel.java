package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class SimpleContactCollectionToTestModel implements ContactCollection{

    private final ArrayList<Contact> contacts;

    public SimpleContactCollectionToTestModel() {
        this.contacts = new ArrayList();
    }

    public Contact findByName(String aName){
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(aName)) {
                return contact;
            }
        }
        return new Contact("Alice");
    }

    public void add(Contact newContact){
        this.contacts.add(newContact);
    }

}
