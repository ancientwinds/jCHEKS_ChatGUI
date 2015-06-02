package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactCollectionTest {
    
    @Test
    public void constructor_should_create_the_contact_collection() throws Exception {
        ContactCollection contactCollection = null;
        contactCollection = new ContactCollectionDefault(new ArrayList());
        assertNotNull(contactCollection);
    }
    
    @Test
    public void constructor_with_contacts_as_parameters_should_create_the_contact_collection(){
        ContactCollection contactCollection = null;
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(new Contact("Alice"));
        contacts.add(new Contact("Bob"));
        contactCollection = new ContactCollectionDefault(contacts);
        assertNotNull(contactCollection);
    }
    
    @Test
    public void constructor_with_contact_array_as_parameter_should_create_the_contact_collection(){
        ContactCollection contactCollection = null;
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(new Contact("Alice"));
        contacts.add(new Contact("Bob"));
        contactCollection = new ContactCollectionDefault(contacts);
        assertNotNull(contactCollection);
    }
    
    @Test (expected=ContactNotFoundException.class)
    public void findByName_Should_throw_an_exception_when_we_search_for_a_unexisting_contact() throws ContactNotFoundException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        String name = "Alice";
        Contact result = contactCollection.findByName(name);
    }
    
    @Test (expected=NameOfContactAlreadyExistInContactsException.class)
    public void addContact_should_throw_an_exception_() throws NameOfContactAlreadyExistInContactsException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        Contact contact = new Contact("Alice");
        contactCollection.add(contact);
        contactCollection.add(contact);
    }
            
}
