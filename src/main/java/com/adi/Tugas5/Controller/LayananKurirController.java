package com.adi.Tugas5.Controller;

import com.adi.Tugas5.Collection.LayananKurir;
import com.adi.Tugas5.Repository.LayananKurirRepo;
import com.adi.Tugas5.Service.LayananKurirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/layananKurir")
public class LayananKurirController {
    @Autowired
    LayananKurirRepo layananKurirRepo;
    @Autowired
    LayananKurirService layananKurirService;

    @GetMapping
    public List<LayananKurir>getAllLayanan(@RequestParam(value = "page", defaultValue = "0") Integer PageNo,
                                           @RequestParam(value = "sortkey", defaultValue = "0")String sortkey ){
        return  layananKurirService.getAllLayananKurir(PageNo, sortkey);
    }
    @PostMapping("/insert")
    public LayananKurir insertLayanan(@RequestBody LayananKurir layananKurirModel) {
        layananKurirService.insertLayananKurir(layananKurirModel);
        return layananKurirModel;
    }
}
