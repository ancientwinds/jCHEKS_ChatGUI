package com.archosResearch.jCHEKS.gui.chat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageTest {

    @Test
    public void constructor_should_create_the_message() {
        Message message = null;
        message = new IncomingMessage("Content of the message.");
        assertNotNull(message);
    }

    @Test
    public void getContent_should_return_the_content_of_the_incomingMessage() {
        Message message = new IncomingMessage("Content of the message.");
        String expResult = "Content of the message.";
        String result = message.getContent();
        assertEquals(expResult, result);
    }

    @Test
    public void getContent_should_return_the_content_of_the_outgoingMmessage() {
        Message message = new OutgoingMessage("Content of the message.");
        String expResult = "Content of the message.";
        String result = message.getContent();
        assertEquals(expResult, result);
    }

}
