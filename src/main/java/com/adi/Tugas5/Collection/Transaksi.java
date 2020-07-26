package com.adi.Tugas5.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaksi")
public class Transaksi {
    @Id
    private String id;
    private String tanggal;
    private String total;
    private String id_pembayaran;

    public Transaksi(){}

    public Transaksi(String id, String tanggal, String total, String id_pembayaran) {
        this.id = id;
        this.tanggal = tanggal;
        this.total = total;
        this.id_pembayaran = id_pembayaran;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(String id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "id='" + id + '\'' +
                ", tanggal='" + tanggal + '\'' +
                ", total='" + total + '\'' +
                ", id_pembayaran='" + id_pembayaran + '\'' +
                '}';
    }
}
