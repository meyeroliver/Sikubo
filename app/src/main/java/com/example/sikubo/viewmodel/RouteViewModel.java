package com.example.sikubo.viewmodel;

import android.app.Application;

import com.example.sikubo.Repository;
import com.example.sikubo.model.Metrorail;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RouteViewModel extends AndroidViewModel {

    private LiveData<List<Metrorail>> allRailRoutes;
    private Repository repository;

    public RouteViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository();
    }

    public void init(){
        if (allRailRoutes != null) {
            // ViewModel is created on a per-Fragment basis, so the userId
            // doesn't change.
            return;
        }
        allRailRoutes = repository.getAllRailRoutes();
    }

    public LiveData<List<Metrorail>> getAllRailRoutes() {
        return allRailRoutes;
    }
}
