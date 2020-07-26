package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="item")
public class Item {
    @Id
    private String id;
    private String nama;
    private int stock;
    private int harga;
    private String description;
    private int terjual;
    private String berat;

    public Item(){}

    public Item(String id, String nama, int stock, int harga, String description, int terjual, String berat) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
        this.description = description;
        this.terjual = terjual;
        this.berat = berat;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTerjual() {
        return terjual;
    }

    public void setTerjual(int terjual) {
        this.terjual = terjual;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", stock=" + stock +
                ", harga=" + harga +
                ", description='" + description + '\'' +
                ", terjual=" + terjual +
                ", berat=" + berat +
                '}';
    }
}

