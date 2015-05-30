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
        MessageCollection aMessageCollection = null;
        aMessageCollection = new MessageCollection(new ArrayList());
        assertNotNull(aMessageCollection);
    }
    
    @Test
    public void getAllMessage_should_return_a_void_arrayList_if_there_is_no_message() throws Exception {
        ArrayList<Message> exepectedResult = new ArrayList();
        MessageCollection aMessageCollection = new MessageCollection(exepectedResult);
        ArrayList<Message> result = null;
        result = aMessageCollection.getAllMessages();
        assertEquals(result, exepectedResult);
    }
    
}
