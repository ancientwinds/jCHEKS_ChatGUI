package com.archosResearch.jCHEKS.gui.chat.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ContactTest {

    @Test
    public void constructor_should_create_a_contact() {
        Contact contact = null;
        contact = new ContactDefault("Name");
        assertNotNull(contact);
    }
    
    @Test
    public void getName_should_return_the_name_of_the_contact() {
        Contact contact = new ContactDefault("Name");
        String expectedResult = "Name";
        String result = contact.getName();
        assertEquals(expectedResult, result);
    }
    
}
