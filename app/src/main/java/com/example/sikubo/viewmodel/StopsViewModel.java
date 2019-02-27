package com.example.sikubo.viewmodel;

import android.app.Application;

import com.example.sikubo.api.Repository;
import com.example.sikubo.model.Route;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class StopsViewModel extends AndroidViewModel {

    private LiveData<List<Route>> allStopsOnARailRoute;
    private Repository repository;

    public StopsViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository();
    }

    public LiveData<List<Route>> getAllStopsOnARailRoute(String id) {
        if (this.allStopsOnARailRoute != null) {
            return null;
        }
        this.allStopsOnARailRoute = repository.getAllStopsOnARailRoute(id);

        return allStopsOnARailRoute;
    }
}
