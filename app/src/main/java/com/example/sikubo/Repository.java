package com.example.sikubo;


import android.app.Application;
import android.app.ListActivity;

import com.example.sikubo.model.GoldenArrow;
import com.example.sikubo.model.Metrorail;
import com.example.sikubo.model.MyCiti;

import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class Repository {

    private GoMetroApi goMetroApi;


    public Repository() {
        goMetroApi = RetroClass.getGoMetroApi();
    }

    public LiveData<List<Metrorail>> getAllRailRoutes() {
        final MutableLiveData<List<Metrorail>> mutableLiveData = new MutableLiveData<>();
        goMetroApi.getAllRailRoutes().enqueue(new Callback<List<Metrorail>>() {
            @Override
            public void onResponse(Call<List<Metrorail>> call, Response<List<Metrorail>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    mutableLiveData.setValue(null);
                    return;
                }
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Metrorail>> call, Throwable t) {
                /**
                 * TODO: show errors
                 */
                mutableLiveData.setValue(null);
            }
        });

        return mutableLiveData;
    }

    public LiveData<List<MyCiti>> getAllTramRoutes() {
        final MutableLiveData<List<MyCiti>> mutableLiveData = new MutableLiveData<>();
        goMetroApi.getAllTramRoutes().enqueue(new Callback<List<MyCiti>>() {
            @Override
            public void onResponse(Call<List<MyCiti>> call, Response<List<MyCiti>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    mutableLiveData.setValue(null);
                    return;
                }
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MyCiti>> call, Throwable t) {
                /**
                 * TODO: show errors
                 */
                mutableLiveData.setValue(null);
            }
        });

        return mutableLiveData;
    }

    public LiveData<List<GoldenArrow>> getAllBuslRoutes() {
        final MutableLiveData<List<GoldenArrow>> mutableLiveData = new MutableLiveData<>();
        goMetroApi.getAllBusRoutes().enqueue(new Callback<List<GoldenArrow>>() {
            @Override
            public void onResponse(Call<List<GoldenArrow>> call, Response<List<GoldenArrow>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    mutableLiveData.setValue(null);
                    return;
                }
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<GoldenArrow>> call, Throwable t) {
                /**
                 * TODO: show errors
                 */
                mutableLiveData.setValue(null);
            }
        });

        return mutableLiveData;
    }




}
