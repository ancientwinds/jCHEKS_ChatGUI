package com.archosResearch.jCHEKS.gui.chat.model;

import mock.SimpleContactCollectionToTestModel;
import mock.StubCommunicator;
import mock.ObserverMock;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ModelTest {

    @Test
    public void constructor_should_construct_the_object() {
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
    public void addOutgoingMessage_should_broadcast_message_sent() throws NameOfContactAlreadyExistInContactsException {
        Model model = new ModelDefault(new ContactCollectionDefault());
        ObserverMock observer = new ObserverMock();
        Contact contact = new Contact("Bob", new StubCommunicator());
        model.addContact(contact);
        model.addObserver(observer);
        model.addOutgoingMessage("Test message", contact);
        assertEquals("Test message", observer.lastMessageSent.getContent());
    }

    @Test
    public void addIncomingMessage_should_broadcast_message_received() throws NameOfContactAlreadyExistInContactsException {
        Model model = new ModelDefault(new ContactCollectionDefault());
        ObserverMock observer = new ObserverMock();
        Contact contact = new Contact("Bob", new StubCommunicator());
        model.addContact(contact);
        model.addObserver(observer);
        model.addIncomingMessage("Test message", contact);
        assertEquals("Test message", observer.lastMessageReceived.getContent());
    }

    @Test
    public void findMessagesByContact_should_return_message_sent() throws Exception {
        Model model = new ModelDefault(new ContactCollectionDefault());
        Contact contact = new Contact("Bob", new StubCommunicator());
        model.addContact(contact);
        model.addOutgoingMessage("This is a test message", contact);
        ArrayList<AbstractMessage> result = model.findMessagesByContact(contact.getName());
        assertEquals(result.get(0).getContent(), "This is a test message");
    }

    @Test
    public void addIncomingMessage_should_not_broadcast_message_received_when_observer_has_been_removed() throws NameOfContactAlreadyExistInContactsException {
        Model model = new ModelDefault(new ContactCollectionDefault());
        ObserverMock observer = new ObserverMock();
        Contact contact = new Contact("Bob", new StubCommunicator());
        model.addContact(contact);
        model.addObserver(observer);
        model.removeObserver(observer);
        model.addIncomingMessage("Test message", contact);
        assertNull(observer.lastMessageReceived);
    }

}
