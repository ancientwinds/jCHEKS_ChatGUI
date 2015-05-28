package com.archosResearch.jCHEKS.gui.chat.model;

import com.archosResearch.jCHEKS.gui.chat.model.Message;
/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver{
    public void newMessageSent(String contactName, String message);
    public void newMessageReceived(String contactName, String message);
}
