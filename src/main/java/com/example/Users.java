package com.example;

public class Users {
    private String userName;
    private int userCardNumber;
    private int userPinCode;
    private int userBalance;

    public Users(String userName, int userCardNumber, int userPinCode, int userBalance) {
        this.userName = userName;
        this.userCardNumber = userCardNumber;
        this.userPinCode = userPinCode;
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserCardNumber() {
        return userCardNumber;
    }

    public void setUserCardNumber(int userCardNumber) {
        this.userCardNumber = userCardNumber;
    }

    public int getUserPinCode() {
        return userPinCode;
    }

    public void setUserPinCode(int userPinCode) {
        this.userPinCode = userPinCode;
    }

    public int getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(int userBalance) {
        this.userBalance = userBalance;
    }
}
