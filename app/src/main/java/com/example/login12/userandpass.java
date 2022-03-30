package com.example.login12;

import android.widget.EditText;

import java.util.ArrayList;

public class userandpass {
    private final ArrayList <String> user =new ArrayList<>();

    private final ArrayList <String> pass =new ArrayList<>();

    public ArrayList<String> getUser() {
        return user;
    }

    public void  setUser(String user) {
        this.user.add(String.valueOf(user));
    }

    public ArrayList<String> getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass.add(String.valueOf(pass));
    }
}
