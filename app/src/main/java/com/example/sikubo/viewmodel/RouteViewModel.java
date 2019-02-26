package com.example.sikubo.viewmodel;

import com.example.sikubo.model.Route;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RouteViewModel extends ViewModel {
    private LiveData<List<Route>> allRoutes;

    public LiveData<List<Route>> getAllRoutes() {
        return allRoutes;
    }

}
