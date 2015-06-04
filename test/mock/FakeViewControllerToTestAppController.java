package mock;

import com.archosResearch.jCHEKS.concept.engine.AbstractEngine;
import com.archosResearch.jCHEKS.engine.model.contact.Contact;
import com.archosResearch.jCHEKS.engine.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.engine.model.message.OutgoingMessage;
import com.archosResearch.jCHEKS.gui.chat.view.InputOutputManager;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class FakeViewControllerToTestAppController implements InputOutputManager {

    public void setEngine(AbstractEngine engine) {

    }

    public void forwardOutgoingMessage(String messageContent, String contactName) {

    }

    @Override
    public void messageSent(OutgoingMessage message, String contactName) {

    }

    @Override
    public void messageReceived(IncomingMessage message, String contactName) {

    }

    @Override
    public void contactAdded(Contact contact) {

    }

    @Override
    public void forwardOutgoingMessage(String messageContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSelectedContactName(String name) {
    }
}
