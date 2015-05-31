package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface ModelObservable{
    public void addObserver(ModelObserver observer);
    public void removeObserver(ModelObserver observer);
    public void notifyNewMessageSent(Contact contact, Message message);
    public void notifyNewMessageReceived(Message message);
}