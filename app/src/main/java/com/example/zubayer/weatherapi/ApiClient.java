package com.example.zubayer.weatherapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zubayer on 5/25/2018.
 */

public class ApiClient {
    static String url="http://api.openweathermap.org/data/2.5/forecast/daily?q=comilla&mode=json&units=metric&cnt=14&&appid=b505284cc7606e04108e38cdaead2570";
    static String base_url="http://api.openweathermap.org/data/2.5/forecast/";

        static Retrofit retrofit=null;
     public static Retrofit getApiClient(){

        retrofit=new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();
            return retrofit;

    }

        String Url2="http://api.openweathermap.org/data/2.5/weather?q=comilla&units=metric&&appid=b505284cc7606e04108e38cdaead2570";
         static String baseUrl2="http://api.openweathermap.org/data/2.5/";

        static Retrofit retrofit2=null;
         public static Retrofit getApiclient2(){


             retrofit2=new Retrofit.Builder().baseUrl(baseUrl2).addConverterFactory(GsonConverterFactory.create()).build();

             return retrofit2;
         }

    static String url3 = "http://api.openweathermap.org/data/2.5/forecast?q=comilla&mode=json&units=metric&&appid=b505284cc7606e04108e38cdaead2570";
    static String base_url3 = "http://api.openweathermap.org/data/2.5/";

    static Retrofit retrofit3 = null;

    public static Retrofit getApiClient3() {

        retrofit3 = new Retrofit.Builder().baseUrl(base_url3).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit3;
    }
}
