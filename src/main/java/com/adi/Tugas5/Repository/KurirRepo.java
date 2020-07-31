package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.Kurir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KurirRepo extends MongoRepository<Kurir, String> {

    @Override
    Optional<Kurir> findById(String s);

    List<Kurir> findByName(String name);
}
