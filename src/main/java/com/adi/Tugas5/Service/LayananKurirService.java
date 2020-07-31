package com.adi.Tugas5.Service;

import com.adi.Tugas5.Collection.LayananKurir;
import com.adi.Tugas5.Repository.KurirRepo;
import com.adi.Tugas5.Repository.LayananKurirRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LayananKurirService {
    @Autowired
    LayananKurirRepo layananKurirRepo;

    @Autowired
    KurirRepo kurirRepo;

    public Optional<LayananKurir>getLayananById (final String id){
        return layananKurirRepo.findById(id);
    }

    public List<LayananKurir> getAllLayananKurir(final Integer pageNo, final String sortKey) {
        final int noOfRecord = 5;
        final Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        final Page<LayananKurir> pagedResult = layananKurirRepo.findAll(page);
        return pagedResult.getContent();
    }

    public void insertLayananKurir(LayananKurir layananKurirModel) {
        layananKurirRepo.save(layananKurirModel);
    }
}
