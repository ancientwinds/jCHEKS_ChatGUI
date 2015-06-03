package mock;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ContactNotFoundException;
import com.archosResearch.jCHEKS.gui.chat.model.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.AbstractMessage;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.model.OutgoingMessage;
import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class FakeModelToTestAppController implements Model {

    public void addContact(Contact contact) throws NameOfContactAlreadyExistInContactsException {

    }

    public void addOutgoingMessage(String messageContent, Contact contact) {

    }

    public void addIncomingMessage(String messageContent, Contact contact) {

    }

    public ArrayList<AbstractMessage> findMessagesByContact(String contactName) throws ContactNotFoundException {
        return null;
    }

    @Override
    public void addObserver(ModelObserver observer) {

    }

    @Override
    public void removeObserver(ModelObserver observer) {

    }

    @Override
    public void broadcastMessageSent(OutgoingMessage message, Contact contact) {

    }

    @Override
    public void broadcastMessageReceived(IncomingMessage message, Contact contact) {

    }

}
