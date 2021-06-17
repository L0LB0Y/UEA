package com.example.uaenew;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("top-headlines?country=ar&apiKey=71f81d9d7d054d34836780e266e2e2d9")
    Call<List<UAEData>> getAllData();
}
