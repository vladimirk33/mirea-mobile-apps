package com.mirea.kateninva.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<HistoricEvent> historicEvents;
    private Context context;

    public EventRecyclerAdapter(List<HistoricEvent> historicEvents) {
        this.historicEvents = historicEvents;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.view_item, parent,
                        false);
        return new EventViewHolder(recyclerViewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        HistoricEvent historicEvent = this.historicEvents.get(position);
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(historicEvent.getImage(),
                "drawable", pkgName);

        holder.getImageView().setImageResource(resID);
        holder.getTitleText().setText(historicEvent.getTitle());
        holder.getDescriptionText().setText(historicEvent.getDescription());
    }

    @Override
    public int getItemCount() {
        return historicEvents.size();
    }
}
