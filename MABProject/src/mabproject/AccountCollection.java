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
public class AccountCollection {
      List<Account> accounts;
      public static final String pathToHome = System.getProperty("user.home") + File.separator + File.separator +"MABProject";
      public AccountCollection () {
          accounts = new LinkedList <> ();
      }
      public boolean Login (Account NewAcc) {
        ListIterator<Account> iter = accounts.listIterator();
        while (iter.hasNext()) {
            Account ct = iter.next();
            if (ct.getUsername().equals( NewAcc.getUsername()) && ct.getPassword().equals( NewAcc.getPassword())) {
                return true;
            }
        }
        return false;
      }
      public boolean AddAccount (Account NewAccount) {
        return accounts.add(NewAccount);
      }
      public boolean RemoveAccount (Account ToBeRemoved) {
        return accounts.remove(ToBeRemoved);
      }
      public Account FindAccountUserName (String UName) {
        ListIterator<Account> iter = accounts.listIterator();
        while (iter.hasNext()) {
            Account ct = iter.next();
            if (ct.getUsername().equals(UName)) {
                return ct;
            }
        }
        return null;
    }
      public List <Account> getAccounts () {
        return accounts;
    }
    public void save(String pathToFile) throws IOException {
        File f = new File(pathToFile);
        
        FileOutputStream fout = new FileOutputStream(f, false);
        ObjectOutputStream out = new ObjectOutputStream(fout);

        out.writeObject(accounts);
        out.close();
    }
    public void load(String pathToFile) throws IOException, ClassNotFoundException {
        
            FileInputStream file = new FileInputStream(pathToFile);
            ObjectInputStream in = new ObjectInputStream(file);
            accounts = (ArrayList<Account>) in.readObject();
        
        
    }
}
