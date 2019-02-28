package com.example.sikubo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.model.Route;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StopsAdaptor extends RecyclerView.Adapter<StopsAdaptor.StopsHolder> {

    public static final String LINE_UPDATES = "com.example.sikubo.LINE_UPDATES";
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

    public void setAllStopsOnARailRoute(List<Route> allStopsOnARailRoute) {
        this.allStopsOnARailRoute = allStopsOnARailRoute;
        notifyDataSetChanged();
    }

    class StopsHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView stopName;

        public StopsHolder(@NonNull View itemView) {
            super(itemView);
            this.stopName = itemView.findViewById(R.id.stop_title);
            this.stopName.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView textView = view.findViewById(R.id.stop_title);
            String stopName = textView.getText().toString().trim();

            String id = "";
            /**
             * convert list into hashmap
             */
            for (Route route : allStopsOnARailRoute) {
                if (stopName.equals(route.getName())) {
                    id = route.getId();
                    break;
                }
            }

            Intent intent = new Intent(view.getContext(), LineUpdatesActivity.class);
            intent.putExtra(LINE_UPDATES, id);
            view.getContext().startActivity(intent);
        }
    }
}
