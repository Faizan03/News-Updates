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
//    @GET("entertainment")
//    Call<ResponseNews> getEntertainment();
//    @GET("business")
//    Call<ResponseNews> getBusiness();
//    @GET("sports")
//    Call<ResponseNews> getSports();
//    @GET("technology")
//    Call<ResponseNews> getTechnology();
}
//top-headlines?country=in&apiKey=9b4e99737a544c5aad6fc8f6be3c5f99&category=