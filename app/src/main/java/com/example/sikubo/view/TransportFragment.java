package com.example.sikubo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.R;
import com.example.sikubo.TransportAdaptor;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class TransportFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_transport, container, false);

        /**
         * TODO: check whether there are any memory leaks
         */

        List<String> transport = new ArrayList<>();
        transport.add("Metrorail");
        transport.add("Myciti");
        transport.add("Golden Arrow");

        RecyclerView recyclerView = view.findViewById(R.id.transport_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        TransportAdaptor transportAdaptor = new TransportAdaptor();
        transportAdaptor.setTransport(transport);
        recyclerView.setAdapter(transportAdaptor);

        return view;
    }

}

