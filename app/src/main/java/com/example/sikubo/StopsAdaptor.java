package com.example.sikubo;

import android.content.Intent;
import android.net.Uri;
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

            double latitude = 0;
            double longitude = 0;

            /**
             * convert list into hashmap
             */
            for (Route route : allStopsOnARailRoute) {
                if (stopName.equals(route.getName())) {
                    longitude = route.getLon();
                    latitude = route.getLat();
                    break;
                }
            }

            /*Intent intent = new Intent(view.getContext(), LineUpdatesActivity.class);
            intent.putExtra(LINE_UPDATES, id);
            view.getContext().startActivity(intent);*/
            Uri gmmIntentUri = Uri.parse("geo:"+latitude+","+longitude+"");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(view.getContext().getPackageManager()) != null) {

                // Attempt to start an activity that can handle the Intent
                view.getContext().startActivity(mapIntent);;
            }

        }
    }
}
