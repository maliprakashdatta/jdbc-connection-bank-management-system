package com.swsa.model;

public class Account {

    long accountNo;
    double balance;
    long mobileNo;
    String accountType;
    String branchName;
    String accountHolderName;
    String gender;
    String dob;
    String address;
    String emailId;
    long aadhaarNo;


    //Setter and Getter Methods
    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

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


//Constructor


    public Account(long accountNo, double balance, long mobileNo, String accountType, String branchName, String accountHolderName, String gender, String dob, String address, String emailId, long aadhaarNo) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.mobileNo = mobileNo;
        this.accountType = accountType;
        this.branchName = branchName;
        this.accountHolderName = accountHolderName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.emailId = emailId;
        this.aadhaarNo = aadhaarNo;
    }

//toString method
@Override
public String toString() {
    return "Account{" +
            "accountNo=" + accountNo +
            ", balance=" + balance +
            ", mobileNo=" + mobileNo +
            ", accountType='" + accountType + '\'' +
            ", branchName='" + branchName + '\'' +
            ", accountHolderName='" + accountHolderName + '\'' +
            ", gender='" + gender + '\'' +
            ", dob='" + dob + '\'' +
            ", address='" + address + '\'' +
            ", emailId='" + emailId + '\'' +
            ", aadhaarNo=" + aadhaarNo +
            '}';
}

}
