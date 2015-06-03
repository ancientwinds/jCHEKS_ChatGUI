package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public abstract class AbstractModel extends ModelObservable {

    public abstract void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException;

    public abstract void addIncomingMessage(String messageContent, Contact contact);

    public abstract void addOutgoingMessage(String messageContent, String contactName);
}
