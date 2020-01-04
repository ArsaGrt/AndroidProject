package com.sobatambyar.foodcourtamikom3;

public class ModelPembelian {

    private String nama_resto;
    private  String nama_makanan;
    private String jumlah_makanan;
    private  String harga_peritem;
    private  String total_harga;

    public ModelPembelian() {
    }

    public ModelPembelian(String nama_resto, String nama_makanan, String jumlah_makanan, String harga_peritem, String total_harga) {
        this.nama_resto = nama_resto;
        this.nama_makanan = nama_makanan;
        this.jumlah_makanan = jumlah_makanan;
        this.harga_peritem = harga_peritem;
        this.total_harga = total_harga;
    }

    //Getter

    public String getNama_resto() {
        return nama_resto;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public String getJumlah_makanan() {
        return jumlah_makanan;
    }

    public String getHarga_peritem() {
        return harga_peritem;
    }

    public String getTotal_harga() {
        return total_harga;
    }


    //Setter


    public void setNama_resto(String nama_resto) {
        this.nama_resto = nama_resto;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public void setJumlah_makanan(String jumlah_makanan) {
        this.jumlah_makanan = jumlah_makanan;
    }

    public void setHarga_peritem(String harga_peritem) {
        this.harga_peritem = harga_peritem;
    }

    public void setTotal_harga(String total_harga) {
        this.total_harga = total_harga;
    }

}
