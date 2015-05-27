package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Message;
/**
 *
 * @author Michael Roussel
 */
public interface ModelObserver {
    public void newMessageSent(Message aMessage);
}
