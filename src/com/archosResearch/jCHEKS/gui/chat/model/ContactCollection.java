package com.archosResearch.jCHEKS.gui.chat.model;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface ContactCollection {
    public Contact findByName(String aName) throws ContactNotFoundException;
    public void add(Contact newContact) throws NameOfContactAlreadyExistInContactsException;
}
