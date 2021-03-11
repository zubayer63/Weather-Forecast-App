package com.example.zubayer.weatherapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Zubayer on 5/25/2018.
 */

public interface ApiInterface {

    /*@GET("daily?q=comilla&mode=json&units=metric&cnt=14&&appid=b505284cc7606e04108e38cdaead2570")
    Call<Example>getExample();

    @GET("weather?q=comilla&units=metric&&appid=b505284cc7606e04108e38cdaead2570")
    Call<ExWeather> getExample2();

    @GET("forecast?q=comilla&mode=json&units=metric&&appid=b505284cc7606e04108e38cdaead2570")
    Call<Example> getExample();*/

    @GET
    Call<Example>getExample(@Url String url);

    @GET
    Call<ExWeather> getExample2(@Url String url);

    @GET
    Call<Example2> getExample3(@Url String url);

}
