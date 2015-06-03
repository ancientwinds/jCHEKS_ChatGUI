package com.archosResearch.jCHEKS.gui.chat.model;

import com.archosResearch.jCHEKS.gui.chat.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.message.OutgoingMessage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public abstract class ModelObservable /* extends AbstractObservable*/{

    private final List<ModelObserver> observers;

    public ModelObservable() {
        this.observers = new ArrayList();
    }

    public void addObserver(ModelObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyMessageSent(OutgoingMessage message, String contactName) {
        for (ModelObserver observer : this.observers) {
            observer.messageSent(message, contactName);
        }
    }

    public void notifyMessageReceived(IncomingMessage message, String contactName) {
        for (ModelObserver observer : this.observers) {
            observer.messageReceived(message, contactName);
        }
    }
}
