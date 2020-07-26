package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.DetailUser;
import com.adi.Tugas5.Collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User deleteByid(String id);

    @Query(value = "{'detailUser.id':?0}", fields = "{'detailUser' : 0}")
    User findByDetailUser(String id);
    List findUserByUsername(String Username);

    Optional<User> findByUsername(String username);
}
