package com.archosResearch.jCHEKS.gui.chat.model;
import java.util.HashMap;
/**
 *
 * @author Michael Roussel <rousselm4@gmail.com>
 */
public class Model extends ModelObservable{
    private final ContactCollection contactCollection;
    private final HashMap<Contact, MessageCollection> map;
    
    public Model(){
        this.contactCollection = new ContactCollection();
        this.map = new HashMap<>();
    }
    
    public void addContact(String contactName){
        this.map.put(new Contact(contactName), new MessageCollection());
        this.contactCollection.add(new Contact(contactName));
    }
    
    public void addMessage(Contact contact, Message message){
        MessageCollection messageCollection = this.map.get(contact);
        messageCollection.addMessage(message);
    }

}
