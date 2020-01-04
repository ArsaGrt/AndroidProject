package com.sobatambyar.foodcourtamikom3;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PembelianFragment extends Fragment {

    View v;
    private  RecyclerView myrecyclerView;
    private List <ModelPembelian> listModelPembelian;

    public PembelianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_pembelian,container,false);
        myrecyclerView = (RecyclerView) v.findViewById(R.id.pembelian_recyclerview);
        PembelianAdapter pembelianAdapter = new PembelianAdapter(getContext(),listModelPembelian);
        myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerView.setAdapter(pembelianAdapter);
       return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listModelPembelian = new ArrayList<>();
        listModelPembelian.add(new ModelPembelian("Mie ayam pak min","Mie ayam","2","Rp.10.000","Rp.10.000"));
        listModelPembelian.add(new ModelPembelian("Mie ayam pak min","Mie ayam","2","Rp.10.000","Rp.10.000"));
        listModelPembelian.add(new ModelPembelian("Mie ayam pak min","Mie ayam","2","Rp.10.000","Rp.10.000"));
        listModelPembelian.add(new ModelPembelian("Mie ayam pak min","Mie ayam","2","Rp.10.000","Rp.10.000"));
        listModelPembelian.add(new ModelPembelian("Mie ayam pak min","Mie ayam","2","Rp.10.000","Rp.10.000"));

    }
}
