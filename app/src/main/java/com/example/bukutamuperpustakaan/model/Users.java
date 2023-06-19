package com.example.bukutamuperpustakaan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String userName;
    private String password;
    private String name;
    private String email;
    private String job;
    private String education;
    private String gender;
    private String address;

    private String age;
    private String role;
    private String googleId;


    public Users() {}

    public Users( String userName, String password, String name, String email, String job, String education, String gender, String address, String age, String role, String googleId) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.job = job;
        this.education = education;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.role = role;
        this.googleId = googleId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    protected Users(Parcel in) {
        userName = in.readString();
        password = in.readString();
        name = in.readString();
        email = in.readString();
        job = in.readString();
        education = in.readString();
        gender = in.readString();
        address = in.readString();
        age = in.readString();
        role = in.readString();
        googleId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(job);
        dest.writeString(education);
        dest.writeString(gender);
        dest.writeString(address);
        dest.writeString(age);
        dest.writeString(role);
        dest.writeString(googleId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}


