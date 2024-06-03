package com.otma.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Coach implements Serializable {
    private int coachNo;
    private String coachName;
    private int age;
    private String gender;
    private int experience;
    private String mobileNo;
    private String emailAddress;
    private Set<Player> players;

    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coach coach)) return false;
        return getCoachName().equals(coach.getCoachName()) && getMobileNo().equals(coach.getMobileNo()) && Objects.equals(getEmailAddress(), coach.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoachName(), getMobileNo(), getEmailAddress());
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachNo=" + coachNo +
                ", coachName='" + coachName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", experience=" + experience +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", players=" + players +
                '}';
    }
}
