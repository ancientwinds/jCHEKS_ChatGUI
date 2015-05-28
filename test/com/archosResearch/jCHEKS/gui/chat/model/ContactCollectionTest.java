package com.archosResearch.jCHEKS.gui.chat.model;

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
        aContactCollection = new ContactCollection();
        assertNotNull(aContactCollection);
    }
    
    @Test
    public void constructor_with_contacts_as_parameters_should_create_the_contact_collection(){
        ContactCollection aContactCollection = null;
        aContactCollection = new ContactCollection(new Contact("Alice"), new Contact("Bob"));
        assertNotNull(aContactCollection);
    }
    
    @Test
    public void constructor_with_contact_array_as_parameter_should_create_the_contact_collection(){
        ContactCollection aContactCollection = null;
        aContactCollection = new ContactCollection(new Contact[]{new Contact("Alice"), new Contact("Bob")});
        assertNotNull(aContactCollection);
    }
    
    @Test (expected=ContactNotFoundException.class)
    public void findByName_Should_throw_an_exception_when_we_search_for_a_unexisting_contact() throws ContactNotFoundException{
        ContactCollection instance = new ContactCollection();
        String aName = "Alice";
        Contact result = instance.findByName(aName);
    }
            
}
