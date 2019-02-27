package com.example.sikubo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    public static final String BASE_URL = "http://proserver.gometro.co.za/api/v1";
    private static Retrofit retrofit;
    public static Retrofit getRetroInstance() {

        if (retrofit == null) {
            retrofit = new  Retrofit.Builder()
                    .baseUrl("http://proserver.gometro.co.za/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static GoMetroApi getGoMetroApi() {
        return getRetroInstance().create(GoMetroApi.class);
    }
}
