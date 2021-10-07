package com.example.newsupdates;

import com.example.newsupdates.ResponseNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<ResponseNews> getNews(@Query("country") String country,
                                     @Query("category") String category,
                                     @Query("apiKey") String apiKey);

}
