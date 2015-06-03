package com.archosResearch.jCHEKS.gui.chat.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface MessageCollection {

    public void add(AbstractMessage message);

    public ArrayList<AbstractMessage> getAllMessages();

}
