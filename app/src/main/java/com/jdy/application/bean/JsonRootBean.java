package com.jdy.application.bean;

import java.util.List;

public class JsonRootBean {

    private String bgImage;
    private String gameArea;
    private String gameName;
    private String gameSegment;
    private List<ReplyItemList> replyItemList;
    private String userImage;
    private String userName;


    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public String getGameArea() {
        return gameArea;
    }

    public void setGameArea(String gameArea) {
        this.gameArea = gameArea;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameSegment() {
        return gameSegment;
    }

    public void setGameSegment(String gameSegment) {
        this.gameSegment = gameSegment;
    }

    public List<ReplyItemList> getReplyItemList() {
        return replyItemList;
    }

    public void setReplyItemList(List<ReplyItemList> replyItemList) {
        this.replyItemList = replyItemList;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}