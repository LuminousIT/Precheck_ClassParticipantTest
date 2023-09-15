package com.example.classparticipantstest;

public class Participant {
    private int matricID;
    private String firstname;
    private String surname;
    private int age;
    private String sportType;
    private String award;

    public Participant(int matricID, String firstname, String surname, int age, String sportType, String award) {
        this.matricID = matricID;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.sportType = sportType;
        this.award = award;
    }

    public int getMatricID() {
        return matricID;
    }

    public void setMatricID(int matricID) {
        this.matricID = matricID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
