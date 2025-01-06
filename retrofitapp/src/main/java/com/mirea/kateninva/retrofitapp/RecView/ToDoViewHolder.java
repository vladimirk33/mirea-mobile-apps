package com.mirea.kateninva.retrofitapp.RecView;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirea.kateninva.retrofitapp.R;

public class ToDoViewHolder	extends	RecyclerView.ViewHolder	{

    ImageView imageView;
    TextView textViewTitle;
    CheckBox checkBoxCompleted;

    public ToDoViewHolder(@NonNull View itemView)	{
        super(itemView);

        textViewTitle =	itemView.findViewById(R.id.textViewTitle);
        checkBoxCompleted =	itemView.findViewById(R.id.checkBoxCompleted);
        imageView = itemView.findViewById(R.id.imageView);
    }

}
