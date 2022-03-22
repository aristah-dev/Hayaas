package com.example.safarirides.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static String BASE_URL = "http://10.0.2.2:8000/api/";
    //private  static String BASE_URL ="http://192.168.43.155/safariRides/api/";

    private static Retrofit retrofit;

    public static Retrofit getApiClient()
    {
        if (retrofit==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static ApiService getApiService()
    {
        return getApiClient().create(ApiService.class);
    }
}
