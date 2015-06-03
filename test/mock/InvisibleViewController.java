package mock;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.message.OutgoingMessage;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 *//*
public class InvisibleViewController extends ObserverMock implements ViewController {
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