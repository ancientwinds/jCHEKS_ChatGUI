package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollectionTest {

    @Test
    public void constructor_should_create_the_message_collection() throws Exception {
        MessageCollection messageCollection = null;
        messageCollection = new MessageCollectionDefault(new ArrayList());
        assertNotNull(messageCollection);
    }

    @Test
    public void getAllMessage_should_return_a_void_arrayList_if_there_is_no_message() throws Exception {
        ArrayList<Message> exepectedResult = new ArrayList();
        MessageCollection messageCollection = new MessageCollectionDefault(exepectedResult);
        ArrayList<Message> result = null;
        result = messageCollection.getAllMessages();
        assertEquals(result, exepectedResult);
    }

    @Test
    public void addMessage_should_add_a_message_in_the_message_collection() throws Exception {
        ArrayList<Message> exepectedResult = new ArrayList();
        Message messageToAdd = new OutgoingMessage("This is a test message.");
        exepectedResult.add(messageToAdd);
        MessageCollection messageCollection = new MessageCollectionDefault(exepectedResult);
        messageCollection.add(messageToAdd);
        ArrayList<Message> result = null;
        result = messageCollection.getAllMessages();
        assertEquals(result, exepectedResult);
    }

}
