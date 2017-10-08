/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mabproject;

import java.io.Serializable;

/**
 *
 * @author mac
 */
public class Contact implements Serializable{
    private String FirstName;
    private String LastName;
    private String Adress;
    private String City;
    private int PostalCode;
    private String PhoneNumber;
    public Contact (String LastName, String FirstName, String Adress, String City, int PostalCode, String PhoneNumber) {
       this.FirstName = FirstName;
       this.LastName = LastName;
       this.Adress = Adress;
       this.City = City;
       this.PostalCode = PostalCode;
       this.PhoneNumber = PhoneNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public int getPostalCode() {
        return PostalCode;
    }
    public Boolean EditCity (String City) {
        this.City = City;
        return true;
    }
    public Boolean EditAdress (String NewAdress) {
        this.Adress = NewAdress;
        return true;
    }
    public Boolean EditPostalCode (int NewPostalCode) {
        this.PostalCode = NewPostalCode;
        return true;
    }
    public Boolean EditPhoneNumber (String NewPhoneNumber) {
        this.PhoneNumber = NewPhoneNumber;
        return true;
    }

    @Override
    public String toString() {
        return "Contact{" + "FirstName=" + FirstName + ", LastName=" + LastName + ", Adress=" + Adress + ", City=" + City + ", PostalCode=" + PostalCode + ", PhoneNumber=" + PhoneNumber + '}';
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getAdress() {
        return Adress;
    }

    public String getCity() {
        return City;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    
}
