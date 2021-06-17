package com.example.uaenew;

import com.google.gson.annotations.SerializedName;

public class UAEData {

    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UAEData(String title, String author, String urlToImage, String description) {
        this.title = title;
        this.author = author;
        this.urlToImage = urlToImage;
        this.description = description;
    }
}
