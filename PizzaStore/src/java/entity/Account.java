/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PhamBaoPhi
 */
public class Account {

    private int accountID;
    private String userName;
    private String password;
    private String fullName;
    private int type;

    public Account(int accountID, String userName, String password, String fullName, int type) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.type = type;
    }

    public Account() {
    }

    public int getAccountID() {
        return accountID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getType() {
        return type;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", type=" + type + '}';
    }

}
