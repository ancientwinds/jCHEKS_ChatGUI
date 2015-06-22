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

    public HashSet<ContactInfo> loadContacts(File file) {

        HashSet<ContactInfo> contactList = new HashSet<ContactInfo>() {
        };

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray contacts = (JSONArray) jsonObject.get("contacts");
            for (Object contact : contacts) {
                String contactName = (String) ((JSONObject) contact).get("name");
                String ipAddress = (String) ((JSONObject) contact).get("ip");
                int port = ((Long) ((JSONObject) contact).get("port")).intValue();
                String uniqueId = (String) ((JSONObject) contact).get("unid");
                String receivingChaoticSystem = (String) ((JSONObject) contact).get("rChaotic");
                String sendingChaoticSystem = (String) ((JSONObject) contact).get("sChaotic");
                ContactInfo contactInfo = new ContactInfo(ipAddress, port, contactName, uniqueId, receivingChaoticSystem, sendingChaoticSystem);
                contactList.add(contactInfo);
            }

        } catch (IOException | ParseException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contactList;
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
            obj.put("unid", contact.getUniqueId());
            obj.put("rChaotic", contact.getReceivingChaoticSystem());
            obj.put("sChaotic", contact.getSendingChaoticSystem());

            contactArray.add(obj);
        }

        JSONObject addressBook = new JSONObject();
        addressBook.put("contacts", contactArray);

        return addressBook.toJSONString();
    }
}
