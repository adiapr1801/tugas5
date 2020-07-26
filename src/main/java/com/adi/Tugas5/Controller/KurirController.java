package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Collection.Kurir;
import com.adi.Tugas5.Repository.KurirRepo;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/kurir")
public class KurirController {
    @Autowired
    KurirRepo kurirRepo;

    @PostMapping("/insert")
    public String simpanKurir(@RequestBody Kurir kurir){
        kurirRepo.save(kurir);
        return "Kurir telah ambahkan";
    }

    @GetMapping("getName/{name}")
    public List<Kurir> getByKurir(@PathVariable String name){
        return kurirRepo.findByName(name);
    }
}
