package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "detailuser")
public class DetailUser {
    private String alamat;
    private String phone1;
    private String phone2;
    private String type;
    private String jenis_kelamin;
    private int kode_pos;

    public DetailUser(){}

    public DetailUser(String alamat, String phone1, String phone2, String type, String jenis_kelamin, int kode_pos) {
        this.alamat = alamat;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.type = type;
        this.jenis_kelamin = jenis_kelamin;
        this.kode_pos = kode_pos;
    }


    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public int getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(int kode_pos) {
        this.kode_pos = kode_pos;
    }

    @Override
    public String toString() {
        return "DetailUser{" +
    //            "id='" + id + '\'' +
                ", alamat='" + alamat + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", type='" + type + '\'' +
                ", jenis_kelamin='" + jenis_kelamin + '\'' +
                ", kode_pos='" + kode_pos + '\'' +
                '}';
    }
}

