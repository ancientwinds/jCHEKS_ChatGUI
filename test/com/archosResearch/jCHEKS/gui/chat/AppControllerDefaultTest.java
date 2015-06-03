package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.NameOfContactAlreadyExistInContactsException;
import com.archosResearch.jCHEKS.gui.chat.model.StubCommunicator;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppControllerDefaultTest {

    @Test
    public void constructor_should_construct_the_object() throws NameOfContactAlreadyExistInContactsException {
        AppController appController = null;
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        appController = new AppControllerDefault(fakeModel, fakeViewController);
        assertNotNull(appController);
    }

    @Test
    public void testHandleIncomingMessage() throws NameOfContactAlreadyExistInContactsException {
        String messageContent = "This is a test message";
        String contactName = "Bob";
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        AppController appController = new AppControllerDefault(fakeModel, fakeViewController);
        appController.handleIncomingMessage(messageContent, new Contact("Bob", new StubCommunicator()));
    }

    @Test
    public void testHandleOutgoingMessage() throws NameOfContactAlreadyExistInContactsException {
        String messageContent = "";
        String contactName = "";
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        AppController appController = new AppControllerDefault(fakeModel, fakeViewController);
        appController.handleOutgoingMessage(messageContent, new Contact("Test message", new StubCommunicator()));
    }
}
