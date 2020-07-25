package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Entity.User;
import com.adi.Tugas5.Repository.UserRepo;
import com.adi.Tugas5.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @GetMapping
    public List<User> getAllUser(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return userService.getAllUser(pageNo, sortKey);
    }

    @PostMapping("/insert")
    public Map<String, Object> addNewBook(@RequestBody User body) {
        Map<String, Object> result = new HashMap<>();
        if (userService.saveUser(body)) {
            result.put("success", true);
            result.put("message", "anda berhasil menambah data user");
        } else {
            result.put("successs", false);
            result.put("message", "user gagal ditambahkan");
        }
        return result;
    }

    @DeleteMapping("/delete")
        //id dr param postman
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