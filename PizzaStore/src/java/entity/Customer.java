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
public class Customer {

    private int customerID;
    private String Password;
    private String contactName;
    private String Address;
    private String Phone;

    public Customer(int customerID, String Password, String contactName, String Address, String Phone) {
        this.customerID = customerID;
        this.Password = Password;
        this.contactName = contactName;
        this.Address = Address;
        this.Phone = Phone;
    }

    public Customer() {
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return Password;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", Password=" + Password + ", contactName=" + contactName + ", Address=" + Address + ", Phone=" + Phone + '}';
    }

}
