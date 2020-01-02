package com.sobatambyar.foodcourtamikom3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class MenuResto extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<ModelMenu> menuList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_resto);


        recyclerView = findViewById(R.id.rv);

        menuList = new ArrayList<>();
        menuList.add(new ModelMenu(R.drawable.makanan,"Nasi Goreng", "Rp 10.000"));
        menuList.add(new ModelMenu(R.drawable.makanan,"Nasi Goreng", "Rp 10.000"));
        menuList.add(new ModelMenu(R.drawable.makanan,"Nasi Goreng", "Rp 10.000"));
        menuList.add(new ModelMenu(R.drawable.makanan,"Nasi Goreng", "Rp 10.000"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvliLayoutmanager = layoutManager;

        recyclerView.setLayoutManager(rvliLayoutmanager);

        MenuAdapter adapter = new MenuAdapter(this,menuList);

        recyclerView.setAdapter(adapter);

    }
}
