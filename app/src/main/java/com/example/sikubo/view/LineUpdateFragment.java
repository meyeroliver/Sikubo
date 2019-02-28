package com.example.sikubo.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

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
import com.example.sikubo.model.LineUpdates;
import com.example.sikubo.viewmodel.LineUpdatesViewModel;


public class LineUpdateFragment extends Fragment {

    private LineUpdatesViewModel lineUpdatesViewModel;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_line_updates, container, false);

        recyclerView = view.findViewById(R.id.lineUpdates_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lineUpdatesViewModel = ViewModelProviders.of(getActivity()).get(LineUpdatesViewModel.class);
        /**
         * TODO getStringExtra that carries the stop id
         */
        lineUpdatesViewModel.getRailLineUpdates("13:f12").observe(getActivity(), new Observer<LineUpdates>() {
            @Override
            public void onChanged(LineUpdates lineUpdates) {

            }
        });

    }
}
