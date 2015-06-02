package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface AppController {
    public void handleIncomingMessage(String messageContent, String contactName);
    public void handleOutgoingMessage(String messageContent, Contact contact);
}              