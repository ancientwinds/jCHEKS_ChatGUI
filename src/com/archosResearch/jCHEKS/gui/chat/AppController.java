package com.archosResearch.jCHEKS.gui.chat;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface AppController {
    public void handleIncomingMessage(String messageContent, String contactName);
    public void handleOutgoingMessage(String messageContent, String contactName);
}              