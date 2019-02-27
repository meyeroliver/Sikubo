package com.example.sikubo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.model.Metrorail;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouteAdaptor extends RecyclerView.Adapter<RouteAdaptor.RouteHolder> {

    private List<Metrorail> metrorails;

    @NonNull
    @Override
    public RouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.fragment_route, parent, false);

       return new RouteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteHolder holder, int position) {
        Metrorail metrorail = metrorails.get(position);
        holder.agencyName.setText(metrorail.getAgencyName());
        holder.longName.setText(metrorail.getLongName());
    }

    @Override
    public int getItemCount() {
        return metrorails.size();
    }

    public void setMetrorails(List<Metrorail> metrorails) {
        this.metrorails = metrorails;
        notifyDataSetChanged();
    }

    class RouteHolder extends RecyclerView.ViewHolder {
        private TextView longName;
        private TextView agencyName;

        public RouteHolder(@NonNull View itemView) {
            super(itemView);
            this.longName = itemView.findViewById(R.id.route_title);
            this.agencyName = itemView.findViewById(R.id.route_agency_text);
        }
    }
}
