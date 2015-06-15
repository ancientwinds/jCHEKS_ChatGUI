/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.archosResearch.jCHEKS.gui.chat.filemanager;

import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import java.util.HashSet;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class main {
    
    public static void main(String args[]){
        FileManager fM = new FileManager();
        /*HashSet<ContactInfo> contacts = new HashSet();
        contacts.add(new ContactInfo(("1.1.1.1"), 9000, "Thomas", "TEst"));
        contacts.add(new ContactInfo(("2.2.2.2"), 8050, "Bob", "trete"));

        fM.save(new ContactInfo("39.03.32.45", 1234, "Test", "tesfsddfadsfa"), "test.json");*/
        
        fM.loadContacts("test.json");
    }
}
