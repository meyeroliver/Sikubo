package com.example.sikubo.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sikubo.R;
import com.example.sikubo.RouteAdaptor;
import com.example.sikubo.StopsAdaptor;
import com.example.sikubo.model.Route;
import com.example.sikubo.viewmodel.StopsViewModel;

import java.util.List;

import static com.example.sikubo.RouteAdaptor.ROUTE_STOP;

public class StopsFragment extends Fragment {

    private StopsViewModel stopsViewModel;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_stops, container, false);

        recyclerView = view.findViewById(R.id.stops_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        stopsViewModel = ViewModelProviders.of(getActivity()).get(StopsViewModel.class);
        String id = getActivity().getIntent().getStringExtra(ROUTE_STOP);


        stopsViewModel.getAllStopsOnARailRoute(id).observe(getActivity(), new Observer<List<Route>>() {
            @Override
            public void onChanged(List<Route> routes) {
                StopsAdaptor stopsAdaptor = new StopsAdaptor();
                stopsAdaptor.setAllStopsOnARailRoute(routes);
                recyclerView.setAdapter(stopsAdaptor);

            }
        });
    }
}
