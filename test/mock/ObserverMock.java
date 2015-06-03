package mock;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.IncomingMessage;
import com.archosResearch.jCHEKS.gui.chat.model.ModelObserver;
import com.archosResearch.jCHEKS.gui.chat.model.OutgoingMessage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ObserverMock implements ModelObserver {

    public OutgoingMessage lastMessageSent;
    public IncomingMessage lastMessageReceived;
    public Contact destinationContactOflastMessageSent;
    public Contact senderOflastMessageReceived;
    public Contact lastContactAdded;

    @Override
    public void messageSent(OutgoingMessage message, Contact contact) {
        lastMessageSent = message;
        destinationContactOflastMessageSent = contact;
    }

    @Override
    public void messageReceived(IncomingMessage message, Contact contact) {
        lastMessageReceived = message;
        senderOflastMessageReceived = contact;
    }

    @Override
    public void contactAdded(Contact contact) {
        lastContactAdded = contact;
    }

}
