package com.sobatambyar.foodcourtamikom3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PembelianAdapter extends RecyclerView.Adapter<PembelianAdapter.MyViewHolder>{

    Context mContext;
    List<ModelPembelian> mdata;

    public PembelianAdapter(Context mContext, List<ModelPembelian> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_pembelian,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.tv_nama_restoran.setText(mdata.get(position).getNama_resto());
        holder.tv_nama_makanan.setText(mdata.get(position).getNama_makanan());
        holder.tv_jumlah_makanan.setText(mdata.get(position).getJumlah_makanan());
        holder.tv_harga_peritem.setText(mdata.get(position).getHarga_peritem());
        holder.tv_total_harga.setText(mdata.get(position).getTotal_harga());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public  static class  MyViewHolder extends  RecyclerView.ViewHolder{

        private  TextView tv_nama_restoran;
        private  TextView tv_nama_makanan;
        private  TextView tv_jumlah_makanan;
        private  TextView tv_harga_peritem;
        private  TextView tv_total_harga;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_nama_restoran = (TextView) itemView.findViewById(R.id.nama_resto);
            tv_nama_makanan = (TextView) itemView.findViewById(R.id.nama_makanan);
            tv_jumlah_makanan = (TextView) itemView.findViewById(R.id.jumlah_makanan);
            tv_harga_peritem = (TextView) itemView.findViewById(R.id.harga_peritem);
            tv_total_harga = (TextView) itemView.findViewById(R.id.total_harga);



        }
    }

}




