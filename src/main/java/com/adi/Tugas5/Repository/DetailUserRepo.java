package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.DetailUser;
import com.adi.Tugas5.Collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailUserRepo extends MongoRepository<DetailUser, String> {
    List findByAlamat(String alamat);
}
