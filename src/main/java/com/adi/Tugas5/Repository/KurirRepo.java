package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.Kurir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KurirRepo extends MongoRepository<Kurir, String> {


    List<Kurir> findByName(String nama);
}
