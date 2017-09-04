package com.jdy.application.bean;

import java.util.List;

public class ReplyItemList {

    private String userImage;
    private String userName;
    private boolean male;
    private boolean vip;
    private String gameArea;
    private String gameName;
    private String gameSegment;

    private String replyContent;
    private List<ReplyImage> replyImage;

    private String time;
    private String from;

    private List<CommentItemList> commentItemList;
    private int commentNumber;

    private int praiseNumber;
    private List<String> userList;


    public void setCommentItemList(List<CommentItemList> commentItemList) {
        this.commentItemList = commentItemList;
    }

    public List<CommentItemList> getCommentItemList() {
        return commentItemList;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getCommentNumber() {
        return commentItemList.size();
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setGameArea(String gameArea) {
        this.gameArea = gameArea;
    }

    public String getGameArea() {
        return gameArea;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameSegment(String gameSegment) {
        this.gameSegment = gameSegment;
    }

    public String getGameSegment() {
        return gameSegment;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean getMale() {
        return male;
    }

    public void setPraiseNumber(int praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public int getPraiseNumber() {
        return userList.size();
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyImage(List<ReplyImage> replyImage) {
        this.replyImage = replyImage;
    }

    public List<ReplyImage> getReplyImage() {
        return replyImage;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean getVip() {
        return vip;
    }

    @Override
    public String toString() {
        return "ReplyItemList{" +
                "userImage='" + userImage + '\'' +
                ", userName='" + userName + '\'' +
                ", male=" + male +
                ", vip=" + vip +
                ", gameArea='" + gameArea + '\'' +
                ", gameName='" + gameName + '\'' +
                ", gameSegment='" + gameSegment + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyImage=" + replyImage +
                ", time='" + time + '\'' +
                ", from='" + from + '\'' +
                ", commentItemList=" + commentItemList +
                ", commentNumber=" + commentNumber +
                ", praiseNumber=" + praiseNumber +
                ", userList=" + userList +
                '}';
    }
}