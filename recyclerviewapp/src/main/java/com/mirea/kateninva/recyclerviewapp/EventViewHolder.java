package com.mirea.kateninva.recyclerviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleText;
    private TextView descriptionText;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.event_image);
        titleText = itemView.findViewById(R.id.event_title);
        descriptionText = itemView.findViewById(R.id.event_description);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitleText() {
        return titleText;
    }

    public TextView getDescriptionText() {
        return descriptionText;
    }
}
