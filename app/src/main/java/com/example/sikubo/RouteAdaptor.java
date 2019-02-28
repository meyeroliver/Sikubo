package com.example.sikubo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.model.GoldenArrow;
import com.example.sikubo.model.Metrorail;
import com.example.sikubo.model.MyCiti;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RouteAdaptor extends RecyclerView.Adapter<RouteAdaptor.RouteHolder> {

    public static final String ROUTE_STOP = "com.example.sikubo.ROUTE_STOP";

    private List<Metrorail> metrorails;
    private List<MyCiti> myCitis;
    private List<GoldenArrow> goldenArrows;

    @NonNull
    @Override
    public RouteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.fragment_route, parent, false);

       return new RouteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RouteHolder holder, int position) {

        if (metrorails != null) {
            Metrorail metrorail = metrorails.get(position);
            holder.agencyName.setText(metrorail.getAgencyName());
            holder.longName.setText(metrorail.getLongName());

        } else if (myCitis != null) {
            MyCiti myCiti = myCitis.get(position);
            holder.agencyName.setText(myCiti.getAgencyName());
            holder.longName.setText(myCiti.getLongName());
        }
        else if (goldenArrows != null) {
            GoldenArrow goldenArrow = goldenArrows.get(position);
            holder.agencyName.setText(goldenArrow.getAgencyName());
            holder.longName.setText(goldenArrow.getLongName());

        }
    }

    @Override
    public int getItemCount() {
        int size = 0;

        if (metrorails != null) {
            size = metrorails.size();
        } else if (myCitis != null) {
            size = myCitis.size();
        }
        else if (goldenArrows != null) {
            size = goldenArrows.size();
        }

        return size;
    }

    public void setMetrorails(List<Metrorail> metrorails) {
        this.metrorails = metrorails;
        notifyDataSetChanged();
    }

    public void setMyCitis(List<MyCiti> myCitis) {
        this.myCitis = myCitis;
        notifyDataSetChanged();
    }

    public void setGoldenArrows(List<GoldenArrow> goldenArrows) {
        this.goldenArrows = goldenArrows;
        notifyDataSetChanged();
    }

    class RouteHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView longName;
        private TextView agencyName;

        public RouteHolder(@NonNull View itemView) {
            super(itemView);
            this.longName = itemView.findViewById(R.id.route_title);
            this.agencyName = itemView.findViewById(R.id.route_agency_text);
            this.longName.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TextView textView =  view.findViewById(R.id.route_title);
            String stopName = textView.getText().toString().trim();
            String id = "";
            /**
             * convert list into hashmap
             */
            for (Metrorail metrorail: metrorails) {
                if (stopName.equals(metrorail.getLongName())) {
                    id = metrorail.getId();
                    break;
                }
            }

            Intent intent = new Intent(view.getContext(), StopsActivity.class);
            intent.putExtra(ROUTE_STOP, id);
            view.getContext().startActivity(intent);

        }
    }
}
