package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver{
    //?? QUESTION: Si on veut rajouter une méthode ici, on doit l'implémenter dans toutes les classe qui implemente cette interface.
    public void messageSent(Message message);
    public void messageReceived(Message message);
    public void contactAdded(Contact contact);
}
