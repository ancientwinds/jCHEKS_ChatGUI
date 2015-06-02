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
    public void constructor_with_contact_array_as_parameter_should_create_the_contact_collection(){
        ContactCollection contactCollection = null;
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(new Contact("Alice"));
        contacts.add(new Contact("Bob"));
        contactCollection = new ContactCollectionDefault(contacts);
        assertNotNull(contactCollection);
    }
    
    @Test (expected=ContactNotFoundException.class)
    public void findByName_should_throw_an_exception_when_we_search_and_no_contact_exist() throws ContactNotFoundException, NameOfContactAlreadyExistInContactsException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        contactCollection.add(new Contact("Alice"));
        contactCollection.findByName("Bob");
    }
    
    @Test (expected=ContactNotFoundException.class)
    public void findByName_should_throw_an_exception_when_we_search_for_a_unexisting_contact() throws ContactNotFoundException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        contactCollection.findByName("Alice");
    }
    
    @Test
    public void findByName_return_the_good_contact_it_is_possible() throws ContactNotFoundException, NameOfContactAlreadyExistInContactsException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        Contact contact = new Contact("Alice");
        contactCollection.add(contact);
        String name = "Alice";
        Contact result = contactCollection.findByName(name);
        assertEquals(result, contact);
    }
    
    @Test (expected=NameOfContactAlreadyExistInContactsException.class)
    public void addContact_should_throw_an_exception() throws NameOfContactAlreadyExistInContactsException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        Contact contact = new Contact("Alice");
        contactCollection.add(contact);
        contactCollection.add(contact);
    }
    
        @Test 
    public void addContact_should_add_a_contact_in_contact_collect() throws NameOfContactAlreadyExistInContactsException, ContactNotFoundException{
        ContactCollection contactCollection = new ContactCollectionDefault(new ArrayList());
        Contact contact = new Contact("Alice");
        contactCollection.add(new Contact("Bob"));
        contactCollection.add(contact);
        Contact result = contactCollection.findByName("Alice");
        assertEquals(result, contact);
    }
            
}
