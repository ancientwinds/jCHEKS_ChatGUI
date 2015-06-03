package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.OutgoingMessage;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class FakeViewControllerToTestAppController implements ViewController {

    public void setAppController(AppController appController) {

    }

    public void forwardOutgoingMessage(String messageContent, String contactName) {

    }

    @Override
    public void messageSent(OutgoingMessage message, Contact contact) {

    }

    @Override
    public void messageReceived(IncomingMessage message, Contact contact) {

    }

    @Override
    public void contactAdded(Contact contact) {

    }

    @Override
    public void forwardOutgoingMessage(String messageContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSelectedContact(Contact contact) {
    }
}
