package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver{
    public void messageSent(Message message);
    public void messageReceived(Message message);
    public void addContact(Contact contact);
}
