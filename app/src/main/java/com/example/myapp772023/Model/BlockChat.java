package com.example.myapp772023.Model;

public class BlockChat {
    String id,name,img,loai, status;

    public BlockChat() {

    }

    public BlockChat(String id, String name, String img, String loai) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.loai = loai;
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
