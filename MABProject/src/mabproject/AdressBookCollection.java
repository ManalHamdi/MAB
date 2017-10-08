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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author mac
 */
public class AdressBookCollection {
     public static final String pathToHome = System.getProperty("user.home") + File.separator + File.separator +"MABProject";
    List AdressBooks ;
    public AdressBookCollection () {
        AdressBooks = new LinkedList <> ();
    }
    public boolean addAdressBook (AdressBook adbook) {
        return AdressBooks.add(adbook);
    }
    public boolean removeAdressBook (AdressBook adbook) {
        return AdressBooks.remove (adbook);
    }
    public AdressBook FindAdressBookTitle (String tit) {
        ListIterator<AdressBook> iter = AdressBooks.listIterator();
        while (iter.hasNext()) {
            AdressBook ct = iter.next();
            if (ct.getTitle().equals(tit) ) {
                return ct;
            }
        }
        return null;
    }
    public ArrayList<AdressBook> FindAdressBookUser (String User) {
        ArrayList<AdressBook> results = new ArrayList();
        ListIterator<AdressBook> iter = AdressBooks.listIterator();
        while (iter.hasNext()) {
            AdressBook ct = iter.next();
            if (ct.getUsername().equals(User) ) {
                results.add(ct);
            }
        }
        
        return results;
    }
    public AdressBook FindAdressBookUserTitle (String user, String title) {
        ListIterator<AdressBook> iter = AdressBooks.listIterator();
        while (iter.hasNext()) {
            AdressBook ct = iter.next();
            if (ct.getTitle().equals(title)  && ct.getUsername().equals(user))
                return ct;
        }
        return null;
    }
    @Override
    public String toString () {
        String str = "";
        ListIterator<AdressBook> iter = AdressBooks.listIterator();
        while (iter.hasNext()) {
            AdressBook ct = iter.next();
            str += ct.toString() + "\n";
        }
        return str;
    }
    public List <AdressBook> getAdressBookList () {
        return AdressBooks;
    }
    public void save(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        
        FileOutputStream fout = new FileOutputStream(f, false);
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(AdressBooks);
        out.close();
    }
    public void load(String pathToFile) throws IOException, ClassNotFoundException {
        
            FileInputStream file = new FileInputStream(pathToFile);
            ObjectInputStream in = new ObjectInputStream(file);
            AdressBooks = (ArrayList<AdressBook>) in.readObject();
        
        
    }
}
