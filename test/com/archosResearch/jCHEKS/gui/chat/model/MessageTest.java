package com.archosResearch.jCHEKS.gui.chat.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageTest {
    
    @Test
    public void constructor_should_create_the_message() {
        Message aMessage = null;
        aMessage = new Message(new Contact("Alice"), "Content of the message.");
        assertNotNull(aMessage);
    }

    @Test
    public void getSenderName_should_return_the_name_of_the_sender() {
        Message aMessage = new Message(new Contact("Alice"), "Content of the message.");
        String expResult = "Alice";
        String result = aMessage.getSenderName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void getContent_should_return_the_content_of_the_message() {
        Message aMessage = new Message(new Contact("Alice"), "Content of the message.");
        String expResult = "Content of the message.";
        String result = aMessage.getContent();
        assertEquals(expResult, result);
    }
    
}