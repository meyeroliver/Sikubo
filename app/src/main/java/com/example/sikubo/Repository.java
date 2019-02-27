package com.example.sikubo;



import android.app.Application;
import android.app.ListActivity;

import com.example.sikubo.model.Metrorail;

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


    public Repository(Application application) {

    }

    public LiveData<List<Metrorail>> getAllRailRoutes() {
        final MutableLiveData<List<Metrorail>> mutableLiveData = new MutableLiveData<>();
        goMetroApi.getAllRailRoutes().enqueue(new Callback<List<Metrorail>>() {
            @Override
            public void onResponse(Call<List<Metrorail>> call, Response<List<Metrorail>> response) {
                if (!response.isSuccessful()) {
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
}
