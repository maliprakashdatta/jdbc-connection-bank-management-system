package com.swsa.model;

public class Card {

    int cardId;
    long cardNo;
    long accountNo;
    String accountHolderName;
    int cvv;
    String cardType;



    //Setter And Getter Method
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
//Constructor

    public Card(int cardId, long cardNo, long accountNo, String accountHolderName, int cvv, String cardType) {
        this.cardId = cardId;
        this.cardNo = cardNo;
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.cvv = cvv;
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNo=" + cardNo +
                ", accountNo=" + accountNo +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", cvv=" + cvv +
                ", cardType='" + cardType + '\'' +
                '}';
    }



    }



