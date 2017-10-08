/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mabproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author mac
 */
public class MABProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AdressBookCollection loulou = new AdressBookCollection();
        AdressBook ad = new AdressBook("Maha", "Maha");
        loulou.addAdressBook(ad);
        loulou.addAdressBook(ad); 
        Contact ct = new Contact ("ZA","Hamdi","MOha","Rabat",9889,"2");
       ad.AddContact(ct);
       Contact ct2 = new Contact ("Manal","Hamdi","MOha","Rabat",3411,"2");
       ad.AddContact(ct2);
       LastNameComparator comp = new LastNameComparator() ;
       ad.SortContactLastName(comp);
      Contact e = ad.FindContactName("Manal Hamdi");
        System.out.println(e.getPostalCode()); 
       List<Contact> l = ad.getAdressBook();
      ListIterator <Contact> iter = l.listIterator();
      while (iter.hasNext()) {
          Contact c = iter.next();
          System.out.println(c.getLastName()+" "+c.getPostalCode());
                  
      }
    }
    
}
