package com.reloj.corinne;

public class userModel {
    String userName, userGender;
    int userAge;

    public userModel(String userName, int userAge, String userGender){
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
