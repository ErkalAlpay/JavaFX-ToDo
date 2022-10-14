package com.example.loginscreen4;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private int id;

    private ArrayList<User> kullaniciListesi = new ArrayList<User>();

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    public ArrayList<User> getKullaniciListesi() {
        return kullaniciListesi;
    }
}
