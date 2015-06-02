package com.archosResearch.jCHEKS.gui.chat.scenario;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.AppControllerDefault;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollection;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollectionDefault;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.ModelDefault;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.model.StubCommunicator;
import org.junit.Test;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Scenario {
    
    @Test
    public void scenario1() throws NameOfContactAlreadyExistInContactsException {
        //Init
        ContactCollection contactCollection = new ContactCollectionDefault();
        Model model = new ModelDefault(contactCollection);
        Contact contact = new Contact("Bob", new StubCommunicator());
        model.addContact(contact);
        InvisibleViewController viewController = new InvisibleViewController();
        AppController appController = new AppControllerDefault(model, viewController);
        viewController.setSelectedContact(contact);
        
        //Messages
        appController.handleIncomingMessage("Hello!", "Bob");
        viewController.forwardOutgoingMessage("Hi");
        appController.handleIncomingMessage("How are you?", "Bob");
        viewController.forwardOutgoingMessage("Good, and you?");
        appController.handleIncomingMessage("Fine. Goodbye!", "Bob");
        viewController.forwardOutgoingMessage("Bye!");
        //assertTrue(viewController.workAsExpected());
    }
    
}
