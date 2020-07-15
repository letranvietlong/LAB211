/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0054;

/**
 *
 * @author macbook
 */
public class Contact {
    
    int ID;
    String fullname;
    String group;
    String address;
    String phone;
    String lastname;
    String firstname;

    public Contact() {
    }

    public Contact(int ID, String fullname, String group, String address, String phone, String lastname, String firstname) {
        this.ID = ID;
        this.fullname = fullname;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Contact{" + "ID=" + ID + ", fullname=" + fullname + ", group=" + group + ", address=" + address + ", phone=" + phone + ", lastname=" + lastname + ", firstname=" + firstname + '}';
    }
    
    
    
}
