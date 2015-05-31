package com.archosResearch.jCHEKS.gui.chat.view;
import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public interface ViewController extends ModelObserver{
    public void setAppController(AppController appController);
}
