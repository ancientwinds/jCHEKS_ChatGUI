package com.archosResearch.jCHEKS.gui.chat.filemanager;

import com.archosResearch.jCHEKS.concept.ioManager.ContactInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas Lepage thomas.lepage@hotmail.ca
 */
public class FileManager {
    
    public void save(Set<ContactInfo> contacts, String fileName) {
        this.writeToFile(this.generateJSON(contacts), fileName);
    }
    
    public void save(ContactInfo contact, String fileName) {
        this.writeToFile(this.generateJSON(contact), fileName);
    }
    
    public Set<ContactInfo> loadContacts(String fileName) {
        
        try{
            InputStreamReader ipsr=new InputStreamReader(new FileInputStream(fileName));
            BufferedReader br=new BufferedReader(ipsr);
            String line = br.readLine();

            if(line != null) {
                System.out.println(line);
            }
            br.close(); 
            
            Map<String, String> map = new HashMap<String, String>();
            String[] parts = line.replaceAll("^\\{|\\}$","").split("\"?(:|,)(?![^\\{]*\\})\"?");
            for (int i = 0; i < parts.length -1; i+=2)
                map.put(parts[i], parts[i+1]);
            System.out.println(map.size() + " entries: " + map);
                }       
        catch (Exception e){
            System.out.println(e.toString());
        }
        return null;
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
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"contacts\":[");
        Iterator<ContactInfo> iterator = contacts.iterator();
        while(iterator.hasNext()) {
            ContactInfo contact = iterator.next();
            stringBuilder.append(this.createJSONContact(contact));
            if(iterator.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]}");
        
        return stringBuilder.toString();
    }
    
        private String generateJSON(ContactInfo contact) {
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"contacts\":[");
        stringBuilder.append(this.createJSONContact(contact));
        stringBuilder.append("]}");
        
        return stringBuilder.toString();
    }   
    
    private String createJSONContact(ContactInfo contact) {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("{");
        stringBuilder.append(this.createJSONField("name", contact.getName()));
        stringBuilder.append(this.createJSONField("ip", contact.getIp()));
        stringBuilder.append(this.createJSONField("port", Integer.toString(contact.getPort())));
        stringBuilder.append(this.createJSONField("unid", contact.getUniqueId(), true));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
 
    private String createJSONField(String fieldName, String content) {
        return this.createJSONField(fieldName, content, false);
    }
    
    private String createJSONField(String fieldName, String content, boolean last) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\"");
        stringBuilder.append(fieldName);
        stringBuilder.append("\":\"");
        stringBuilder.append(content);
        stringBuilder.append("\"");
        if(!last) {
            stringBuilder.append(",");
        }
        
        return stringBuilder.toString();
    }
   
}