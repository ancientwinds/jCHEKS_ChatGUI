package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public abstract class Message {

    private final String content;
    //private EState state; (Enum of state)

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}
