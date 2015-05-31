package com.archosResearch.jCHECKS.gui.chat.scenario;

import com.archosResearch.jCHEKS.gui.chat.AppController;
import com.archosResearch.jCHEKS.gui.chat.model.ContactCollection;
import com.archosResearch.jCHEKS.gui.chat.model.Model;
import com.archosResearch.jCHEKS.gui.chat.model.ModelDefault;
import com.archosResearch.jCHEKS.gui.chat.view.ViewController;
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
    public void scenario1() {
        ArrayList contactList = new ArrayList();
        HashMap hashMap = new HashMap<>();
        ContactCollection contactCollection = new ContactCollection(contactList);
        Model model = new ModelDefault(contactCollection, hashMap, contactList); 
        ViewController viewController = ViewController.getInstance();
        new AppController(model, viewController);
    }
}
