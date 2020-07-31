package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "layanankurir")
public class LayananKurir {
    @Id
    private String id;
    private String nama;
    private int harga;
    private int estimasi;
    private Kurir kurir;

    public  LayananKurir(){}

    public LayananKurir(String id, String nama, int harga, int estimasi) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.estimasi = estimasi;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }


    public int getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(int estimasi) {
        this.estimasi = estimasi;
    }

    @Override
    public String toString() {
        return "LayananKurir{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", harga=" + harga +
                ", estimasi=" + estimasi +
                '}';
    }
}
