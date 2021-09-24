package com.example.newsupdates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="https://newsapi.org/v2/";
    private static Retrofit retrofit=null;


    public static Retrofit getClient(){
        if(retrofit==null){
            OkHttpClient okHttpClient= new OkHttpClient.Builder().build();

            Gson gson=new GsonBuilder().create();
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
    return retrofit;
    }
}
