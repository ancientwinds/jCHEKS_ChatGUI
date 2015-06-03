package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollectionTest {

    @Test
    public void constructor_should_create_the_message_collection() throws Exception {
        MessageCollection messageCollection = null;
        messageCollection = new MessageCollectionDefault();
        assertNotNull(messageCollection);
    }

    @Test
    public void getAllMessage_should_return_a_void_arrayList_if_there_is_no_message() throws Exception {
        ArrayList<Message> expectedResult = new ArrayList();
        MessageCollection messageCollection = new MessageCollectionDefault();
        ArrayList<Message> result = null;
        result = messageCollection.getAllMessages();
        assertEquals(result, expectedResult);
    }

    @Test
    public void addMessage_should_add_a_message_in_the_message_collection() throws Exception {

        Message messageToAdd = new OutgoingMessage("This is a test message.");
        ArrayList<Message> expectedResult = new ArrayList();
        expectedResult.add(messageToAdd);
        MessageCollection messageCollection = new MessageCollectionDefault();
        messageCollection.add(messageToAdd);
        ArrayList<Message> result = null;
        result = messageCollection.getAllMessages();
        assertEquals(result, expectedResult);
    }

}
