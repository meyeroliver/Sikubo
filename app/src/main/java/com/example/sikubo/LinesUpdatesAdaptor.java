package com.example.sikubo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sikubo.model.LineUpdates;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinesUpdatesAdaptor extends RecyclerView.Adapter<LinesUpdatesAdaptor.LineUpdatesHolder> {

    private LineUpdates lineUpdates;

    @NonNull
    @Override
    public LineUpdatesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_line_update, parent, false);

        return new LineUpdatesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LineUpdatesHolder holder, int position) {
         holder.stopName.setText(lineUpdates.getUser_name());
        holder.announcement.setText(lineUpdates.getTitle());
        holder.broadMessage.setText("Trains cancelled due to sets out of service");
        String messageArray[] = lineUpdates.getMessage().split(",");
        String first = messageArray[0].substring(messageArray[0].indexOf(":") + 1);
        messageArray[0] = first;
        String message = "";
        for (int i = 0; i < messageArray.length; i++) {
            message += messageArray[i] + "\n";
        }
        holder.affectedTrains.setText(message);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void setLineUpdates(LineUpdates lineUpdates) {
        this.lineUpdates = lineUpdates;
        notifyDataSetChanged();
    }

    class LineUpdatesHolder extends RecyclerView.ViewHolder {
        private TextView stopName;
        private TextView announcement;
        private TextView broadMessage;
        private TextView affectedTrains;

        public LineUpdatesHolder(@NonNull View itemView) {
            super(itemView);
            this.stopName = itemView.findViewById(R.id.warning_title);
            this.announcement = itemView.findViewById(R.id.announcement_text);
            this.broadMessage = itemView.findViewById(R.id.message_text);
            this.affectedTrains = itemView.findViewById(R.id.update_text);
        }
    }
}
