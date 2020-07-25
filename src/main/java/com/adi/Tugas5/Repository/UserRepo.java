package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    User findByUsername(String useranme);
    User deleteByid(String id);
}
