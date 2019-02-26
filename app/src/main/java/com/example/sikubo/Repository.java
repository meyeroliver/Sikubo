package com.example.sikubo;



import android.app.Application;
import android.app.ListActivity;

import com.example.sikubo.model.Metrorail;

import java.util.List;

import javax.inject.Singleton;

import androidx.lifecycle.LiveData;


@Singleton
public class Repository {

    private GoMetroApi goMetroApi;
    private LiveData<List<Metrorail>> allRailRoutes;


    public Repository(Application application) {

    }

    public LiveData<List<Metrorail>> getAllRailRoutes() {
        return allRailRoutes;
    }
}
