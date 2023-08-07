package com.example.myapp772023.Model;

public class Massage {
    private int id;
    private int idAccount;
    private int idBlockChat;
    private String content;
    private String time;
public Massage(){
}
    public Massage(int id, int idAccount, int idBlockChat, String content, String time) {
        this.id = id;
        this.idAccount = idAccount;
        this.idBlockChat = idBlockChat;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdBlockChat() {
        return idBlockChat;
    }

    public void setIdBlockChat(int idBlockChat) {
        this.idBlockChat = idBlockChat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
