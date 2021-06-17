package com.example.uaenew;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("status")
    String status;
    @SerializedName("totalResults")
    Integer totalResults;
    @SerializedName("articles")
    List<UAEData> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<UAEData> getArticles() {
        return articles;
    }

    public void setArticles(List<UAEData> articles) {
        this.articles = articles;
    }

    public Result(String status, Integer totalResults, List<UAEData> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }
}
