package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Collection.Item;
import com.adi.Tugas5.Collection.User;
import com.adi.Tugas5.Repository.ItemRepo;
import com.adi.Tugas5.Repository.UserRepo;
import com.adi.Tugas5.Service.ItemService;
import com.adi.Tugas5.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepo itemRepo;

    @GetMapping("/ambil")
    public List<Item> getAllUser(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return itemService.getAllItem(pageNo, sortKey);
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
    public ResponseEntity<List<Item>> getAllTutorials(@RequestParam(defaultValue = "id,desc") String[] sort) {
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
            List<Item> tutorials = itemRepo.findAll(Sort.by(orders));
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public Map<String, Object> addNewItem(@RequestBody Item body) {
        Map<String, Object> result = new HashMap<>();
        if (itemService.saveItem(body)) {
            result.put("success", true);
            result.put("message", "anda berhasil menambah data user");
        } else {
            result.put("successs", false);
            result.put("message", "user gagal ditambahkan");
        }
        return result;
    }

    @DeleteMapping("/delete")
    Map<String, Object> deleteItem(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (itemService.DeleteItem(id)) {
            result.put("success", true);
            result.put("message", "User berhasil dihapus");
        } else {
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateUser(@RequestBody Item body) {
        Map<String, Object> result = new HashMap<>();
        if (itemService.updateItem(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }
}
