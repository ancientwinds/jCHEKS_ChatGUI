package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface Model extends ModelObservable{
    public void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException;
    public void addIncomingMessage(String messageContent, String contactName);
    public void addOutgoingMessage(String messageContent, String contactName);
    public ArrayList<Message> findMessagesByContact(String contactName) throws ContactNotFoundException;
}
