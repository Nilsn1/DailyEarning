package com.nilscreation.dailyearning;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context context;
    ArrayList<ListModel> applist;

    public ListAdapter(Context context, ArrayList<ListModel> applist) {
        this.context = context;
        this.applist = applist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListModel listModel = applist.get(position);

        Glide.with(context).load(listModel.getImgUrl()).into(holder.appImg);
        holder.title.setText(listModel.getTitle());
        holder.bonusDesc.setText("Get ₹" + listModel.getBonus() + " Bonus");
        holder.bonus.setText("₹" + listModel.getBonus());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Title", listModel.getTitle());
                intent.putExtra("Description", listModel.getDescription());
                intent.putExtra("ImgUrl", listModel.getImgUrl());
                intent.putExtra("AppUrl", listModel.getAppUrl());
                intent.putExtra("Bonus", listModel.getBonus());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return applist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        ImageView appImg;
        TextView title, bonusDesc, bonus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            appImg = itemView.findViewById(R.id.appImg);
            title = itemView.findViewById(R.id.title);
            bonusDesc = itemView.findViewById(R.id.bonusDesc);
            bonus = itemView.findViewById(R.id.bonus);

        }
    }
}
