package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver{
    public void newMessageSent(Contact contact, Message message);
    public void newMessageReceived(Message message);
}
