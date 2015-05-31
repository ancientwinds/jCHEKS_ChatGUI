package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface Model extends ModelObservable{
    public void addContact(String contactName) throws NameOfContactAlreadyExistInContactsException;
    public void addIncomingMessage(Message message);
    public void addOutgoingMessage(Message message);
    public ArrayList<Message> findMessagesByContact(String contactName) throws ContactNotFoundException;
}
