package com.example.myapp772023.Model;

import java.io.Serializable;

    public class Account implements Serializable {
    String id,name,email,stt,age,img,userName,pass;

    public Account() {
    }

    public Account(String id, String name, String email, String stt, String age, String img,String userName, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.stt = stt;
        this.age = age;
        this.img = img;
        this.userName=userName;
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
