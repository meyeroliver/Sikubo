package com.example.sikubo.api;

import com.example.sikubo.model.GoldenArrow;
import com.example.sikubo.model.LineUpdates;
import com.example.sikubo.model.Metrorail;
import com.example.sikubo.model.MyCiti;
import com.example.sikubo.model.Route;
import com.example.sikubo.model.Stop;

import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GoMetroApi {

    /**
     * MetroRail routes
     */
    @GET("rail/routes")
    Call<List<Metrorail>> getAllRailRoutes();
    @GET("rail/routes/{id}/stops")
    Call<List<Route>> getAllStopsOnARailRoute(@Path("id") String id);
    @GET("rail/stop/{id}")
    Call<Stop> getRailStopInfo(@Path("id") String id);
    @GET("rail/lineupdates/{id}")
    Call<LineUpdates> getRailLineUpdates(@Path("id") String id);

    /**
     * MyCiti routes
     */
    @GET("myciti/routes/")
    Call<List<MyCiti>> getAllTramRoutes();
    @GET("myciti/routes/{id}/stops")
    Call<List<Route>> getAllStopsOnATramRoute(@Path("id") String id);
    @GET("myciti/stop/{id}")
    Call<Stop> getTramStopInfo(@Path("id") String id);

    /**
     * Golden Arrow routes
     */
    @GET("ga/routes")
    Call<List<GoldenArrow>> getAllBusRoutes();
    @GET("ga/routes/{id}/stops")
    Call<List<Route>> getAllStopsOnABusRoute(@Path("id") String id);
    @GET("ga/stop/{id}")
    Call<List<Stop>> getBusStopInfo(@Path("id") String id);


}
