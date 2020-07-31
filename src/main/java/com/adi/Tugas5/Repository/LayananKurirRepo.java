package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.LayananKurir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LayananKurirRepo extends MongoRepository<LayananKurir, String> {

    Optional <LayananKurir> findById(String id);

    @Query("{'kurirmodel.id': ?0}")
    List<LayananKurir> findByIdKurir(String id);
}
