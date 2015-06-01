package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class AppControllerDefaultTest {

    @Test 
    public void constructor_should_construct_the_object(){
        AppController appController = null;
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        appController = new AppControllerDefault(fakeModel, fakeViewController);
        assertNotNull(appController);
    }
    
    @Test
    public void testHandleIncomingMessage() {
        String messageContent = "This is a test message";
        String contactName = "Bob";
        Model fakeModel = new FakeModelToTestAppController();
        ViewController fakeViewController = new FakeViewControllerToTestAppController();
        AppController appController = new AppControllerDefault(fakeModel, fakeViewController);
        appController.handleIncomingMessage(messageContent, contactName);
    }

    @Test
    public void testHandleOutgoingMessage() {
        String messageContent = "";
        String contactName = "";
        AppControllerDefault instance = null;
        instance.handleOutgoingMessage(messageContent, contactName);
    }
    
}