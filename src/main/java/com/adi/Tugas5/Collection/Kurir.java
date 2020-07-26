package com.adi.Tugas5.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="kurir")
public class Kurir {
    @Id
    private String id;
    private String name;
    private String resi;

    public Kurir(){}

    public Kurir(String id, String name, String resi) {
        this.id = id;
        this.name = name;
        this.resi = resi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return name;
    }

    public void setNama(String nama) {
        this.name = nama;
    }

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }

    @Override
    public String toString() {
        return "Kurir{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", resi='" + resi + '\'' +
                '}';
    }
}
