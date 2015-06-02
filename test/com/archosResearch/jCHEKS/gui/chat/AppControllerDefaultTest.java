package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppControllerDefaultTest {

    @Test 
    public void constructor_should_construct_the_object() throws NameOfContactAlreadyExistInContactsException{
        AppController appController = null;
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        appController = new AppControllerDefault(new MockEngine(), fakeModel, fakeViewController, "Bob");
        assertNotNull(appController);
    }
    
    @Test
    public void testHandleIncomingMessage() throws NameOfContactAlreadyExistInContactsException {
        String messageContent = "This is a test message";
        String contactName = "Bob";
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        AppController appController = new AppControllerDefault(new MockEngine(), fakeModel, fakeViewController, "Bob");
        appController.handleIncomingMessage(messageContent, contactName);
    }

    @Test
    public void testHandleOutgoingMessage() throws NameOfContactAlreadyExistInContactsException {
        String messageContent = "";
        String contactName = "";
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        AppController appController = new AppControllerDefault(new MockEngine(), fakeModel, fakeViewController, "Bob");
        appController.handleOutgoingMessage(messageContent, contactName);
    }
}