package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {
    @Id
    private String id;
    private String nama;
    private String code;
    private String jenis;

    public Payment(){}

    public Payment(String id, String nama, String code, String jenis) {
        this.id = id;
        this.nama = nama;
        this.code = code;
        this.jenis = jenis;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", code='" + code + '\'' +
                ", jenis='" + jenis + '\'' +
                '}';
    }
}
