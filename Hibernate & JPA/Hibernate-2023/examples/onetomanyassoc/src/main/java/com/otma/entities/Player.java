package com.otma.entities;

import java.io.Serializable;
import java.util.Objects;

public class Player implements Serializable {
    private int playerNo;
    private String playerName;
    private int age;
    private String gender;
    private String mobileNo;
    private String emailAddress;
    private float height;
    private float weight;
    private String sportType;

    private Coach coach;

    public Player() {
    }

    public Player(String playerName, int age, String gender, String mobileNo, String emailAddress, float height, float weight, String sportType) {
        this.playerName = playerName;
        this.age = age;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.emailAddress = emailAddress;
        this.height = height;
        this.weight = weight;
        this.sportType = sportType;
    }

    public int getPlayerNo() {
        return playerNo;
    }

    public void setPlayerNo(int playerNo) {
        this.playerNo = playerNo;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(getPlayerName(), player.getPlayerName()) && Objects.equals(getMobileNo(), player.getMobileNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayerName(), getMobileNo());
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNo=" + playerNo +
                ", playerName='" + playerName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", sportType='" + sportType + '\'' +
                '}';
    }
}
