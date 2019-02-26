package com.example.sikubo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sikubo.model.Route;
import com.example.sikubo.viewmodel.RouteViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

public class RouteFragment extends Fragment {

    private RouteViewModel routeViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       routeViewModel.getAllRoutes().observe(this, new Observer<List<Route>>() {
           @Override
           public void onChanged(List<Route> routes) {
               /**
                * TODO: update UI
                */
           }
       });

    }
}
