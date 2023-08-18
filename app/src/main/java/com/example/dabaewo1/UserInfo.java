package com.example.dabaewo1;


public class UserInfo {
    private String name;
    private String nickname;
    private String email;
    private String gender;
    private String phoneNumber;
    private String address;

    private int age;
    private int job;
    private int interest;
    private int purpose;

    public UserInfo(String name, String nickname, String email, String gender, String phoneNumber, String address, int job, int interest, int purpose, int age){
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.job = job;
        this.interest = interest;
        this.purpose = purpose;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNickname(){
        return this.nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getJob(){
        return this.job;
    }
    public void setJob(int job){
        this.job = job;
    }
    public int getInterest() {
        return this.interest;
    }
    public void setInterest(int interest){
        this.interest = interest;
    }
    public int getPurpose(){
        return this.purpose;
    }
    public void setPurpose(int purpose){
        this.purpose = purpose;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

