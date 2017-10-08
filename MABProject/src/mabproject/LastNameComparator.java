/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mabproject;

import java.util.Comparator;

/**
 *
 * @author mac
 */
public class LastNameComparator implements Comparator<Contact>{
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
