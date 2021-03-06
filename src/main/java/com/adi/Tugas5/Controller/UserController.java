package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Collection.DetailUser;
import com.adi.Tugas5.Collection.User;
import com.adi.Tugas5.Repository.DetailUserRepo;
import com.adi.Tugas5.Repository.UserRepo;
import com.adi.Tugas5.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DetailUserRepo detailUserRepo;

    @Autowired
    UserRepo userRepo;
    private MongoTemplate mongoTemplate;
    public List findAll() {
        return mongoTemplate.findAll(User.class);
    }
    //---------------------------------------------------------------------------------------->>
    //get all user
    @GetMapping("")
    public  List<User> findall(){
        return userRepo.findAll();
    }
    //---------------------------------------------------------------------------------------->>
    @GetMapping("/ambil")
    public List<User> getAllUser(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return userService.getAllUser(pageNo, sortKey);
    }
    //---------------------------------------------------------------------------------------->>
    //get by username
    @GetMapping("/findByUserName")
    public List findDeptByName(@RequestParam String username) {
        return userRepo.findUserByUsername(username);
    }
    //---------------------------------------------------------------------------------------->>
    //get user by alamat
    @GetMapping("/findByAlamat")
    public List findDeptByAlamat(@RequestParam String alamat) {
        return detailUserRepo.findByAlamat(alamat);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }
    //---------------------------------------------------------------------------------------->>
    //shorting secara descending
    @GetMapping("/desc")
    public ResponseEntity<List<User>> getAllTutorials(@RequestParam(defaultValue = "id,desc") String[] sort) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            if (sort[0].contains(",")) {
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }
            List<User> tutorials = userRepo.findAll(Sort.by(orders));
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public User insertUser(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }
    public User save(User user) {
        mongoTemplate.save(user);
        return user;
    }

    @DeleteMapping("/delete")
    Map<String, Object> deleteBook(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (userService.DeleteBook(id)) {
            result.put("success", true);
            result.put("message", "User berhasil dihapus");
        } else {
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateUser(@RequestBody User body) {
        Map<String, Object> result = new HashMap<>();
        if (userService.updateUser(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }
}