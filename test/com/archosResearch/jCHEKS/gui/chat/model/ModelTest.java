package com.archosResearch.jCHEKS.gui.chat.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ModelTest {
    
    @Test
    public void constructor_should_construct_the_model() {
        Model model = null;
        model = new Model();
        assertNotNull(model);
    }

    @Test (expected=ContactAlreadyExistException.class)
    public void addContact_should_throws_ContactAlreadyExistException() {
        String contactName = "Alice";
        Model model = new Model();
        model.addContact(contactName);
        model.addContact(contactName);
    }
/*
    @Test
    public void addIncomingMessage_should_add_the_message_in_the_collection() {
        Model model = new Model();
        model.addIncomingMessage(new Message());
    }
    
    @Test
    public void addOutgoingMessage_should_add_the_message_in_the_collection() {
        Model model = new Model();
        model.addOutgoingMessage(new Message());
    }
    */
}
