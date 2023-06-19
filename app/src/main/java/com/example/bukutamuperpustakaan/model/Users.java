package com.example.bukutamuperpustakaan.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {
    private String userId;
    private String name;
    private String email;
    private String job;
    private String education;
    private String gender;
    private String age;
    private String address;

    public Users() {}

    public Users(String userId, String name, String email, String job, String education, String gender, String age, String address) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.job = job;
        this.education = education;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    protected Users(Parcel in) {
        userId = in.readString();
        name = in.readString();
        email = in.readString();
        job = in.readString();
        education = in.readString();
        gender = in.readString();
        age = in.readString();
        address = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(job);
        dest.writeString(education);
        dest.writeString(gender);
        dest.writeString(age);
        dest.writeString(address);
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

