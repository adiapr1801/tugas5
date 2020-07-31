package com.adi.Tugas5.Repository;

import com.adi.Tugas5.Collection.Item;
import com.adi.Tugas5.Collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends MongoRepository<Item, String> {
    Item findByName(String name);
    Item deleteByid(String id);
}
