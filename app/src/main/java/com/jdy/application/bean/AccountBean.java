package com.jdy.application.bean;

/**
 * Created by Dale on 2017/8/21.
 */

public class AccountBean {
    private int accountImageView;
    private String accountName;
    private String accountDescribe;
    private boolean isVip;
    private ArticleBean article;

    public AccountBean(int accountImageView, String accountName, String accountDescribe, boolean isVip, ArticleBean article) {
        this.accountImageView = accountImageView;
        this.accountName = accountName;
        this.accountDescribe = accountDescribe;
        this.isVip = isVip;
        this.article = article;
    }

    public int getAccountImageView() {
        return accountImageView;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountDescribe() {
        return accountDescribe;
    }

    public boolean isVip() {
        return isVip;
    }

    public ArticleBean getArticle() {
        return article;
    }
}
