package com.example.sikubo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sikubo.GoMetroApi;
import com.example.sikubo.R;
import com.example.sikubo.RetroClass;
import com.example.sikubo.RouteAdaptor;
import com.example.sikubo.TransportAdaptor;
import com.example.sikubo.model.Metrorail;
import com.example.sikubo.viewmodel.RouteViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RouteFragment extends Fragment {

    private RouteViewModel routeViewModel;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_route, container, false);

        recyclerView = view.findViewById(R.id.route_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        routeViewModel = ViewModelProviders.of(getActivity()).get(RouteViewModel.class);
        routeViewModel.init();

        routeViewModel.getAllRailRoutes().observe(getActivity(), new Observer<List<Metrorail>>() {
            @Override
            public void onChanged(List<Metrorail> metrorails) {

                RouteAdaptor routeAdaptor = new RouteAdaptor();
                routeAdaptor.setMetrorails(metrorails);
                recyclerView.setAdapter(routeAdaptor);
            }
        });

    }
}
