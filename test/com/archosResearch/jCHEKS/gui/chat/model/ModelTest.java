package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.HashMap;
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
        model = new ModelDefault(new ContactCollection(new ArrayList()), new HashMap(), new ArrayList());
        assertNotNull(model);
    }

    @Test (expected=NameOfContactAlreadyExistInContactsException.class)
    public void addContact_should_throws_NameOfContactAlreadyExistInContactsException() throws NameOfContactAlreadyExistInContactsException {
        String contactName = "Alice";
        Model model = new ModelDefault(new ContactCollection(new ArrayList()), new HashMap(), new ArrayList());
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
