package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver {

    //TODO Should we separate this into multiple interface?
    public void messageSent(OutgoingMessage message, Contact contact);

    public void messageReceived(IncomingMessage message, Contact contact);

    public void contactAdded(Contact contact);
}
