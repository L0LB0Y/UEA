package com.example.uaenew;

public class RestData {
    private String imgUrl;
    private String author;
    private String title;
    private String description;

    public RestData(String imgUrl, String author, String title, String description) {
        this.imgUrl = imgUrl;
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
