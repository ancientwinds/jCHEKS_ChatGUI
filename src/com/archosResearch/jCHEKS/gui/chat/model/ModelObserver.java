package com.archosResearch.jCHEKS.gui.chat.model;

import com.archosResearch.jCHEKS.gui.chat.model.contact.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.message.OutgoingMessage;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver {

    //TODO Should we separate this into multiple interface?
    public void messageSent(OutgoingMessage message, String contactName);

    public void messageReceived(IncomingMessage message, String contactName);

    public void contactAdded(Contact contact);
}
