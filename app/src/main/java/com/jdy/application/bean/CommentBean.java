package com.jdy.application.bean;

/**
 * Created by Dale on 2017/8/21.
 */

public class CommentBean {
    private String commenter;
    private String comment;

    public CommentBean(String commenter, String comment) {
        this.commenter = commenter;
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public String getComment() {
        return comment;
    }
}
