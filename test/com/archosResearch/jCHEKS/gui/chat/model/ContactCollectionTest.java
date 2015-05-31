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
        ContactCollection aContactCollection = null;
        aContactCollection = new ContactCollection(new ArrayList());
        assertNotNull(aContactCollection);
    }
    
    @Test
    public void constructor_with_contacts_as_parameters_should_create_the_contact_collection(){
        ContactCollection aContactCollection = null;
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(new ContactDefault("Alice"));
        contacts.add(new ContactDefault("Bob"));
        aContactCollection = new ContactCollection(contacts);
        assertNotNull(aContactCollection);
    }
    
    @Test
    public void constructor_with_contact_array_as_parameter_should_create_the_contact_collection(){
        ContactCollection aContactCollection = null;
        ArrayList<Contact> contacts = new ArrayList();
        contacts.add(new ContactDefault("Alice"));
        contacts.add(new ContactDefault("Bob"));
        aContactCollection = new ContactCollection(contacts);
        assertNotNull(aContactCollection);
    }
    
    @Test (expected=ContactNotFoundException.class)
    public void findByName_Should_throw_an_exception_when_we_search_for_a_unexisting_contact() throws ContactNotFoundException{
        ContactCollection instance = new ContactCollection(new ArrayList());
        String aName = "Alice";
        Contact result = instance.findByName(aName);
    }
            
}
