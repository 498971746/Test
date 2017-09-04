package com.jdy.application.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dale on 2017/8/21.
 */

public class ArticleBean {

    private String articleTitle;//发表文章的标题，这里的说说一般是无标题的
    private String articleContentText;//发表文章的文字内容
    private List<Integer> articleContentImage; //发表文章的图片内容
    private Date articleDate; //发表文章的日期
    private List<String> articleLikes;//文章被点赞的用户列表
    private List<CommentBean> comments;

    public ArticleBean(String articleContentText, List<Integer> images, Date articleDate,
                       List<String> articleLikes, List<CommentBean> comments) {
        this("空间说说", articleContentText, images, articleDate, articleLikes, comments);
    }

    public ArticleBean(String articleTitle, String articleContentText, List<Integer> images, Date articleDate,
                       List<String> articleLikes, List<CommentBean> comments) {
        this.articleTitle = articleTitle;
        this.articleContentText = articleContentText;
        this.articleContentImage = new ArrayList<>();

        for (int i = 0; i < images.size(); i++)
            articleContentImage.add(images.get(i));

        this.articleDate = articleDate;

        this.articleLikes = new ArrayList<>();
        for (int i = 0; i < articleLikes.size(); i++)
            this.articleLikes.add(articleLikes.get(i));

        this.comments = comments;
    }

    public boolean isEmpty(){
        return articleContentText == null && articleContentImage == null;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getArticleContentText() {
        return articleContentText;
    }

    public List<Integer> getArticleContentImage() {
        return articleContentImage;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public List<String> getArticleLikes() {
        return articleLikes;
    }

    public List<CommentBean> getComments() {
        return comments;
    }
}
