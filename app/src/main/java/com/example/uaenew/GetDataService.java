package com.example.uaenew;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    @GET("v2/top-headlines")
    Call<Example> getAllData(@Query("country") String country, @Query("apiKey") String apiKey);
}
