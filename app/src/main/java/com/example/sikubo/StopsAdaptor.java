package com.example.sikubo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.model.Route;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StopsAdaptor extends RecyclerView.Adapter<StopsAdaptor.StopsHolder> {

    private List<Route> allStopsOnARailRoute;

    @NonNull
    @Override
    public StopsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_stops, parent, false);

        return new StopsHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull StopsHolder holder, int position) {
        Route route = allStopsOnARailRoute.get(position);
        holder.stopName.setText(route.getName());
    }

    @Override
    public int getItemCount() {
        return allStopsOnARailRoute.size();
    }

    class StopsHolder extends RecyclerView.ViewHolder {
        private TextView stopName;

        public StopsHolder(@NonNull View itemView) {
            super(itemView);
            this.stopName = itemView.findViewById(R.id.stop_title);
        }
    }
}
