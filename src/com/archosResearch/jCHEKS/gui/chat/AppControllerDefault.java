package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.AbstractModel;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppControllerDefault implements AppController {

    private final AbstractModel model;
    private final ViewController viewController;

    public AppControllerDefault(AbstractModel model, ViewController viewController) throws NameOfContactAlreadyExistInContactsException {
        this.viewController = viewController;
        this.viewController.setAppController(this);
        this.model = model;
        this.model.addObserver(this.viewController);
    }

    public void handleIncomingMessage(String messageContent, Contact contact) {
        this.model.addIncomingMessage(messageContent, contact);
    }

    public void handleOutgoingMessage(String messageContent, Contact contact) {
        this.model.addOutgoingMessage(messageContent, contact);
    }
}
