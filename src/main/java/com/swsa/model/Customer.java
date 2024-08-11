package com.swsa.model;

public class Customer {

    int customerId;
    String name;
    long mobileNo;
    String address;
    String emailId;
    long aadhaarNo;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
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



    public Customer(int customerId, String name, long mobileNo, String address, String emailId, long aadhaarNo) {
        this.customerId = customerId;
        this.name = name;
        this.mobileNo = mobileNo;
        this.address = address;
        this.emailId = emailId;
        this.aadhaarNo = aadhaarNo;
    }
        @Override
        public String toString() {
            return "Customer{" +
                    "customerId=" + customerId +
                    ", name='" + name + '\'' +
                    ", mobileNo=" + mobileNo +
                    ", address='" + address + '\'' +
                    ", emailId='" + emailId + '\'' +
                    ", aadhaarNo=" + aadhaarNo +
                    '}';
        }

    }




