package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface ModelObservable{
    public void addObserver(ModelObserver observer);
    public void removeObserver(ModelObserver observer);
    public void broadcastMessageSent(Message message, Contact contact);
    public void broadcastMessageReceived(Message message);
}