package com.archosResearch.jCHEKS.gui.chat.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollectionTest {
    
    public MessageCollectionTest() {
    }

    @Test
    public void constructor_should_create_the_message_collection() throws Exception {
        ContactCollection aContactCollection = null;
        aContactCollection = new ContactCollection();
        assertNotNull(aContactCollection);
    }
    
}
