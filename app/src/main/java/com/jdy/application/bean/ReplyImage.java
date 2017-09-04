package com.jdy.application.bean;

public class ReplyImage {

    private String contentImage;

    public void setContentImage(String contentImage) {
         this.contentImage = contentImage;
     }

    public String getContentImage() {
         return contentImage;
     }

    @Override
    public String toString() {
        return "ReplyImage{" +
                "contentImage='" + contentImage + '\'' +
                '}';
    }
}