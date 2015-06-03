package mock;

import com.archosResearch.jCHEKS.engine.model.contact.Contact;
import com.archosResearch.jCHEKS.engine.model.message.IncomingMessage;
import com.archosResearch.jCHEKS.engine.model.ModelObserver;
import com.archosResearch.jCHEKS.engine.model.message.OutgoingMessage;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class ObserverMock implements ModelObserver {

    public OutgoingMessage lastMessageSent;
    public IncomingMessage lastMessageReceived;
    public String destinationContactOflastMessageSent;
    public String senderOflastMessageReceived;
    public Contact lastContactAdded;

    @Override
    public void messageSent(OutgoingMessage message, String contactName) {
        lastMessageSent = message;
        destinationContactOflastMessageSent = contactName;
    }

    @Override
    public void messageReceived(IncomingMessage message, String contactName) {
        lastMessageReceived = message;
        senderOflastMessageReceived = contactName;
    }

    @Override
    public void contactAdded(Contact contact) {
        lastContactAdded = contact;
    }

}
