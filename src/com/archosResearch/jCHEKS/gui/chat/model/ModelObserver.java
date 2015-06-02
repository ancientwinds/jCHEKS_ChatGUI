package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver{
    //TODO Should we separate this into multiple interface?
    public void messageSent(Message message, Contact contact);
    public void messageReceived(Message message);
    public void contactAdded(Contact contact);
}
