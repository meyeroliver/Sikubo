package com.example.sikubo.viewmodel;

import android.app.Application;

import com.example.sikubo.Repository;
import com.example.sikubo.model.GoldenArrow;
import com.example.sikubo.model.Metrorail;
import com.example.sikubo.model.MyCiti;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class RouteViewModel extends AndroidViewModel {

    private LiveData<List<Metrorail>> allRailRoutes;
    private LiveData<List<MyCiti>> allTramRoutes;
    private LiveData<List<GoldenArrow>> allBusRoutes;
    private Repository repository;

    public RouteViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository();
    }

    public LiveData<List<Metrorail>> getAllRailRoutes() {
        if (this.allRailRoutes != null) {
            return null;
        }
        this.allRailRoutes = this.repository.getAllRailRoutes();
        return this.allRailRoutes;
    }

    public LiveData<List<MyCiti>> getAllTramRoutes() {
        if (this.allTramRoutes != null) {
            return  null;
        }
        this.allTramRoutes = this.repository.getAllTramRoutes();
        return this.allTramRoutes;
    }

    public LiveData<List<GoldenArrow>> getAllBusRoutes() {
        if (this.allBusRoutes != null){
            return null;
        }
        this.allBusRoutes = this.repository.getAllBuslRoutes();
        return this.allBusRoutes;
    }
}
