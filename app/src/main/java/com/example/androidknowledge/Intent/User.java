package com.example.androidknowledge.Intent;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        String s ="Name :" + this.getName() + "\n" + "SĐT :" + this.getPhone();
        return s;
    }
}
