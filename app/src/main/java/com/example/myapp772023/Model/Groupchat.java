package com.example.myapp772023.Model;

import android.widget.ImageView;

public class Groupchat {
    int id;
    String name, img,loai,content;

    public Groupchat() {
    }

    public Groupchat(int id, String name,String content, String img, String loai) {
        this.id = id;
        this.name = name;
        this.content=content;
        this.img = img;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}
