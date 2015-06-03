package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class MessageCollectionDefault implements MessageCollection {

    private final ArrayList<AbstractMessage> messages;

    public MessageCollectionDefault() {
        this.messages = new ArrayList();
    }

    public void add(AbstractMessage message) {
        this.messages.add(message);
    }

    public ArrayList<AbstractMessage> getAllMessages() {
        return this.messages;
    }

}
