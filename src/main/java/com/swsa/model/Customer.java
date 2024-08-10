package com.swsa.model;

public class Customer {

    String accountHolderName;
    String gender;
    long mobileNo;
    String dob;
    String address;
    String emailId;
    long aadhaarNo;

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(long aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }



    public Customer(String accountHolderName, String gender, long mobileNo, String dob, String address, String emailId, long aadhaarNo) {
        this.accountHolderName = accountHolderName;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.address = address;
        this.emailId = emailId;
        this.aadhaarNo = aadhaarNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNo=" + mobileNo +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", aadhaarNo=" + aadhaarNo +
                '}';
    }



}
