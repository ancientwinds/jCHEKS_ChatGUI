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
    public void constructor_should_construct_the_object(){
        Model model = null;
        model = new ModelDefault(new SimpleContactCollectionToTestModel());
        assertNotNull(model);
    }
    
    @Test
    public void addContact_should_call_addContact_in_contactCollection() throws Exception {
        Contact contact = new Contact("", new StubCommunicator());
        SimpleContactCollectionToTestModel contactCollection = new SimpleContactCollectionToTestModel();
        Model model = new ModelDefault(contactCollection);
        model.addContact(contact);
        assertEquals(contactCollection.contacts.get(0).getName(), contact.getName());
    }

    @Test
    public void testAddOutgoingMessage() {
        String messageContent = "";
        String contactName = "";
        Model model = null;
        model.addOutgoingMessage(messageContent, contactName);
    }

    @Test
    public void testAddIncomingMessage() {
        String messageContent = "";
        String contactName = "";
        Model model = null;
        model.addIncomingMessage(messageContent, contactName);
    }

    @Test
    public void testFindMessagesByContact() throws Exception {
        System.out.println("findMessagesByContact");
        String contactName = "";
        Model model = null;
        ArrayList<Message> expResult = null;
        ArrayList<Message> result = model.findMessagesByContact(contactName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddObserver() {
        ModelObserver observer = null;
        ModelObservableDefault model = null;
        model.addObserver(observer);
    }

    @Test
    public void testRemoveObserver() {
        ModelObserver observer = null;
        ModelObservableDefault model = null;
        model.removeObserver(observer);
    }

    @Test
    public void testBroadcastMessageSent() {
        Message message = null;
        ModelObservableDefault model = null;
        model.broadcastMessageSent(message);
    }

    @Test
    public void testBroadcastMessageReceived() {
        Message message = null;
        ModelObservableDefault model = null;
        model.broadcastMessageReceived(message);
    }
    
}
