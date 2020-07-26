package com.adi.Tugas5.Service;

import com.adi.Tugas5.Collection.Item;
import com.adi.Tugas5.Collection.User;
import com.adi.Tugas5.Repository.ItemRepo;
import com.adi.Tugas5.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public List<Item> getAllItem(Integer pageNo, String sortKey){
        int noOfRecord = 1;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<Item> pagedResult = itemRepo.findAll(page);
        return pagedResult.getContent();
    }


    public boolean updateItem(Item body) {
        Optional<Item> itemResult = itemRepo.findById(body.getId());

        if (itemResult != null) {
            try {

                itemRepo.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean saveItem(Item body) {

        try {
            itemRepo.save(body);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean DeleteItem(String id) {
        Item result = itemRepo.deleteByid(id);
        if (result != null) {
            try {
                itemRepo.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }
}
