package com.mirea.kateninva.drinkproject.recyclers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mirea.kateninva.drinkproject.R;
import com.mirea.kateninva.domain.models.Drink;

import java.util.List;

public class RandomDrinkRecyclerAdapter extends RecyclerView.Adapter<RandomDrinkViewHolder> {

    private List<Drink> drinkList;
    private Context context;

    public RandomDrinkRecyclerAdapter(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public RandomDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.drink_item, parent, false);

        return new RandomDrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomDrinkViewHolder holder, int position) {
        Drink drink = drinkList.get(position);

        Glide.with(context)
                .load(drink.getStrDrinkThumb())
                .placeholder(R.drawable.placeholder)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NonNull Target<Drawable> target, boolean isFirstResource) {
                        Toast.makeText(context, "Что-то пошло не так", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(@NonNull Drawable resource, @NonNull Object model, Target<Drawable> target, @NonNull DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(holder.getImageView());
        holder.getTextView().setText(drink.getStrDrink());
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }
}

