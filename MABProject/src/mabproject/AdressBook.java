/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mabproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author mac
 */
public class AdressBook implements Serializable {   //AdressBook is a collection of contacts
    List<Contact> contacts;
    private String title;
    private String Username;
    public AdressBook (String title, String userName) {
        this.contacts = new LinkedList<>();
        this.title = title;
        this.Username = userName;
    }
      public AdressBook (String title) {
          this.contacts = new LinkedList<>();
          this.title = title;
      }
    public boolean AddContact (Contact NewContact) {
        return contacts.add(NewContact);
    }
    public boolean RemoveContact (Contact ToBeRemoved) {
        return contacts.remove(ToBeRemoved);
    }
    public boolean EditContact (Contact Search, Contact newContact) {
        int index = contacts.indexOf(Search);
        if (index < 0)
            return false;
        else {
            contacts.set(index, newContact);
            return true;
        }
    }
    public Contact FindContactLastName (String LName) {
        ListIterator<Contact> iter = contacts.listIterator();
        while (iter.hasNext()) {
            Contact ct = iter.next();
            if (ct.getLastName().equals(LName)) {
                return ct;
            }
        }
        return null;
    }
    public Contact FindContactName (String LName) {
        ListIterator<Contact> iter = contacts.listIterator();
        while (iter.hasNext()) {
            Contact ct = iter.next();
            if ((ct.getLastName()+" "+ct.getFirstName()).equals(LName)) {
                return ct;
            }
        }
        return null;
    }
    public void SortContactLastName (Comparator comp) {
        Collections.sort(contacts, comp);
    }
    public void SortContactPostalCode (Comparator comp) {
        Collections.sort(contacts, comp);
    }
    @Override
    public String toString () {
        return title;
    }
    public String toStrings () {
        String str = "";
        ListIterator<Contact> iter = contacts.listIterator();
        while (iter.hasNext()) {
            Contact ct = iter.next();
            str += ct.toString() + "\n";
        }
        return str;
    }
    public List <Contact> getAdressBook () {
        return contacts;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return Username;
    }
     public void save(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        
        FileOutputStream fout = new FileOutputStream(f, false);
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(contacts);
        out.close();
    }
    
    public void load(String pathToFile) throws IOException, ClassNotFoundException {
        
            FileInputStream file = new FileInputStream(pathToFile);
            ObjectInputStream in = new ObjectInputStream(file);
            contacts = (ArrayList<Contact>) in.readObject();
        
        
    }
    
}
