package com.mirea.kateninva.drinkproject.recyclers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kateninva.drinkproject.R;

public class RandomDrinkViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public RandomDrinkViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.title);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

}
