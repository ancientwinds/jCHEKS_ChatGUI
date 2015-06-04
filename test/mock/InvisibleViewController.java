package mock;

import com.archosResearch.jCHEKS.engine.model.contact.Contact;
import com.archosResearch.jCHEKS.engine.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.engine.model.message.OutgoingMessage;
import com.archosResearch.jCHEKS.gui.chat.view.InputOutputManager;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 *//*
public class InvisibleViewController extends ObserverMock implements InputOutputManager {
    private AppController appController;
    private Contact selectedContact;

    @Override
    public void setEngine(AppController appController) {
        this.appController = appController;
    }

    @Override
    public void forwardOutgoingMessage(String messageContent) {
        this.appController.handleOutgoingMessage(messageContent, this.selectedContact);
    }

    @Override
    public void setSelectedContact(Contact selectedContact) {
        this.selectedContact = selectedContact;
    }
}
*/