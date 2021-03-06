package com.sobatambyar.foodcourtamikom3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private Context mContext;
    private  ArrayList<ModelMenu> mlist;
    MenuAdapter (Context context, ArrayList<ModelMenu> list){
        mContext = context;
        mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

       View view =  layoutInflater.inflate(R.layout.rv_menu_items,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelMenu menuItem = mlist.get(position);

        ImageView image = holder.item_image;
        TextView name,price;

        name = holder.item_name;
        price = holder.item_price;

        image.setImageResource(menuItem.getImage());

        name.setText(menuItem.getName());
        price.setText(menuItem.getPrice());

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentoToMakanan = new Intent(mContext,Makanan.class);
                mContext.startActivity(intentoToMakanan);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView item_image;
        TextView item_name , item_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_price = itemView.findViewById(R.id.item_price);

        }

    }

}
