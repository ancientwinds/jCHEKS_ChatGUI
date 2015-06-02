package com.archosResearch.jCHEKS.gui.chat.scenario;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.AppControllerDefault;
import com.archosResearch.jCHEKS.gui.chat.MockEngine;
import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollection;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollectionDefault;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.ModelDefault;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.model.StubCommunicator;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

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
        model.addContact(new Contact("Bob", new StubCommunicator()));
        InvisibleViewController viewController = new InvisibleViewController();
        AppController appController = new AppControllerDefault(model, viewController);
        
        //Messages
        appController.handleIncomingMessage("Hello!", "Bob");
        viewController.forwardOutgoingMessage("Hi", "Bob");
        appController.handleIncomingMessage("How are you?", "Bob");
        viewController.forwardOutgoingMessage("Good, and you?", "Bob");
        appController.handleIncomingMessage("Fine. Goodbye!", "Bob");
        viewController.forwardOutgoingMessage("Bye!", "Bob");
        //assertTrue(viewController.workAsExpected());
    }
    
}
