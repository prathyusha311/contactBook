package com.plivo.contactBook.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

    @Id
    private String mobileNumber;

    private String emailId;

    private String name;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
