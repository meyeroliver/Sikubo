package com.example.sikubo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransportAdaptor extends RecyclerView.Adapter<TransportAdaptor.TransportHolder> {

    private List<String> transport = new ArrayList<>();

    @NonNull
    @Override
    public TransportHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_transport, parent, false);

        return new TransportHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransportHolder holder, int position) {
        String vehicle = transport.get(position);
        holder.transportTitle.setText(vehicle);

    }

    @Override
    public int getItemCount() {
        return transport.size();
    }

    public void setTransport(List<String> transport) {
        this.transport = transport;
        notifyDataSetChanged();
    }

    class TransportHolder extends RecyclerView.ViewHolder {
        private TextView transportTitle;

        public TransportHolder(@NonNull View itemView) {
            super(itemView);
            transportTitle = itemView.findViewById(R.id.transport_card_label);
        }
    }
}
