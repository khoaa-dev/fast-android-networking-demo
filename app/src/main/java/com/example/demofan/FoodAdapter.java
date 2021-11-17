package com.example.demofan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.listFoodViewHolder> {
    Context context;
    ArrayList<Food> listFood;

    public FoodAdapter(Context context, ArrayList<Food> listFood) {
        this.context = context;
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public listFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View v = inflater.inflate(R.layout.item_food, parent, false);

        return new listFoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull listFoodViewHolder holder, int position) {
        Food itemFood = listFood.get(position);

        holder.name.setText(itemFood.getName());
        holder.price.setText(itemFood.getPrice().toString());
        Picasso.get().load("https://i.ibb.co/QPhT8kK/114072886-3140363829388949-332199438268767343-o.jpg").into(holder.img);
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public static class listFoodViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView img;
        public listFoodViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_food);
            price = itemView.findViewById(R.id.price_food);
            img = itemView.findViewById(R.id.img_food);
        }
    }
}
