package com.archosResearch.jCHEKS.gui.chat;

import com.archosResearch.jCHEKS.gui.chat.model.Contact;
import com.archosResearch.jCHEKS.gui.chat.model.Message;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;

/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class FakeViewControllerToTestAppController implements ViewController{
    public void setAppController(AppController appController){
        
    }
    public void forwardOutgoingMessage(String messageContent, String contactName){
        
    }

    @Override
    public void messageSent(Message message) {
        
    }

    @Override
    public void messageReceived(Message message) {
        
    }

    @Override
    public void contactAdded(Contact contact) {
        
    }
}
