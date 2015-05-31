package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;
import java.util.Observable;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface MessageCollection{
    public void addMessage(Message aMessage);
    public ArrayList<Message> getAllMessages();

}
