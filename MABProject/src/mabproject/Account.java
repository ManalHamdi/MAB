/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mabproject;

/**
 *
 * @author mac
 */
public class Account {
    private String Username;
    private String Password;
    public Account (String Username, String Password) {
        this.Password = Password;
        this.Username = Username;
    }
    
    public boolean ChangePassword (String NewPassword) {
        this.Password = NewPassword;
        return true;
    }
    public boolean EditUsername (String NewUsername) {
        this.Username = NewUsername;
        return true;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }
    
}
