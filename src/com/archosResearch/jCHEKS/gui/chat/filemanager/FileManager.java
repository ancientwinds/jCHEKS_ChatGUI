package com.archosResearch.jCHEKS.gui.chat.filemanager;

import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class FileManager {

    public void save(Set<ContactInfo> contacts, String fileName) {
        this.writeToFile(this.generateJSON(contacts), fileName);
    }

    public void save(ContactInfo contact, String fileName) {
        HashSet<ContactInfo> contacts = new HashSet();
        contacts.add(contact);
        this.writeToFile(this.generateJSON(contacts), fileName);
    }

    public HashSet<ContactInfo> loadContacts(File file, String ownName) {

        HashSet<ContactInfo> contactList = new HashSet();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray contacts = (JSONArray) jsonObject.get("contacts");
            for (Object contact : contacts) {
                String contactName = (String) ((JSONObject) contact).get("name");
                String ipAddress = (String) ((JSONObject) contact).get("ip");
                int port = ((Long) ((JSONObject) contact).get("port")).intValue();
                String receivingSystem = generateChaoticSystemName(contactName, ownName);
                String sendingSystem = generateChaoticSystemName(ownName, contactName);
                ContactInfo contactInfo = new ContactInfo(ipAddress, port, contactName, receivingSystem, sendingSystem);
                contactList.add(contactInfo);
            }

        } catch (IOException | ParseException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactList;
    }
    
    public String generateChaoticSystemName(String contactNameLeft, String contactNameRight) {
        contactNameLeft = contactNameLeft.replace("-", "");
        contactNameRight = contactNameRight.replace("-", "");
        return contactNameLeft + "-" + contactNameRight + ".xml";
    }
    
    private void writeToFile(String content, String fileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            writer.write(content);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String generateJSON(Set<ContactInfo> contacts) {
        JSONArray contactArray = new JSONArray();

        Iterator<ContactInfo> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            ContactInfo contact = iterator.next();

            JSONObject obj = new JSONObject();
            obj.put("name", contact.getName());
            obj.put("ip", contact.getIp());
            obj.put("port", contact.getPort());

            contactArray.add(obj);
        }

        JSONObject addressBook = new JSONObject();
        addressBook.put("contacts", contactArray);

        return addressBook.toJSONString();
    }
}
