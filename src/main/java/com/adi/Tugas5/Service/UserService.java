package com.adi.Tugas5.Service;

import com.adi.Tugas5.Collection.DetailUser;
import com.adi.Tugas5.Collection.User;
import com.adi.Tugas5.Repository.DetailUserRepo;
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
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    DetailUserRepo detailUserRepo;

    public List<User> getAllUser(Integer pageNo, String sortKey){
        int noOfRecord = 1;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<User> pagedResult = userRepo.findAll(page);
        return pagedResult.getContent();
    }


    public boolean updateUser(User body) {
        Optional<User> userResult = userRepo.findById(body.getId());

        if (userResult != null) {
            try {

                userRepo.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean saveUser(User body) {

        try {
            userRepo.save(body);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean DeleteBook(String id) {
        User result = userRepo.deleteByid(id);
        if (result != null) {
            try {
                userRepo.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }


}
