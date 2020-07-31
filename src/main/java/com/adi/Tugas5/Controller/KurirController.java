package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Collection.Kurir;
import com.adi.Tugas5.Repository.KurirRepo;
import com.adi.Tugas5.Service.KurirService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/kurir")
public class KurirController {
    @Autowired
    KurirRepo kurirRepo;

    @Autowired
    KurirService kurirService;

    @PostMapping("/insert")
    public String simpanKurir(@RequestBody Kurir kurir){
        kurirRepo.save(kurir);
        return "Kurir telah ambahkan";
    }

    @GetMapping("getName/{name}")
    public List<Kurir> getByKurir(@PathVariable String name){
        return kurirRepo.findByName(name);
    }

    @GetMapping
    public  List<Kurir>getAllKurir(@RequestParam(value = "page", defaultValue = "0") Integer PageNo,
                                   @RequestParam(value = "sortkey", defaultValue = "username") String sortkey){
        return  kurirService.getAllKurir(PageNo,sortkey);
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody Kurir body) {
        Map<String, Object> result = new HashMap<>();
        if (kurirService.updateKurir(body)) {
            result.put("Status", true);
            result.put("Massage", "Berhasil Update data");
        } else {
            result.put("Status", false);
            result.put("Massage", "Gagal Update");
        }
        return result;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteById(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (kurirService.deleteById(id)){
            result.put("Status", true);
            result.put("Massage", "Success");
        } else {
            result.put("Status", false);
            result.put("Massage", "Failed");
        }
        return result;
    }
}
