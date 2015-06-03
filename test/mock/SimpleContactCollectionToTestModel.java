package mock;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollection;
import com.archosResearch.jCHEKS.gui.chat.model.ContactNotFoundException;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import java.util.ArrayList;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class SimpleContactCollectionToTestModel implements ContactCollection {

    public final ArrayList<Contact> contacts;

    public SimpleContactCollectionToTestModel() {
        this.contacts = new ArrayList();
    }

    public Contact findByName(String aName) throws ContactNotFoundException {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(aName)) {
                return contact;
            }
        }
        throw new ContactNotFoundException();
    }

    public void add(Contact newContact) throws NameOfContactAlreadyExistInContactsException {
        for (Contact aContact : this.contacts) {
            if (aContact.getName().equals(newContact.getName())) {
                throw new NameOfContactAlreadyExistInContactsException();
            }
        }
        this.contacts.add(newContact);
    }

}
