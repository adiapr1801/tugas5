package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pembayaran")
public class Pembayaran {
    @Id
    private String id;
    private String id_payment;

    public Pembayaran(){}

    public Pembayaran(String id, String id_payment) {
        this.id = id;
        this.id_payment = id_payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_payment() {
        return id_payment;
    }

    public void setId_payment(String id_payment) {
        this.id_payment = id_payment;
    }

    @Override
    public String toString() {
        return "Pembayaran{" +
                "id='" + id + '\'' +
                ", id_payment='" + id_payment + '\'' +
                '}';
    }
}
