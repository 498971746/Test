package com.jdy.application.bean;

public class CommentItemList {

    private String content;
    private boolean female;
    private String userName;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean getFemale() {
        return female;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}