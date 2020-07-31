package com.adi.Tugas5.Service;

import com.adi.Tugas5.Collection.Kurir;
import com.adi.Tugas5.Repository.KurirRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KurirService {
    @Autowired
    KurirRepo kurirRepo;

    public Optional<Kurir> getKurirById(final String id) {
        return kurirRepo.findById(id);
    }

    public List<Kurir> getAllKurir(final Integer pageNo, final String sortKey) {
        final int noOfRecord = 5;
        final Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        final Page<Kurir> pagedResult = kurirRepo.findAll(page);
        return pagedResult.getContent();
    }

    public void insertKurir(final Kurir kurir) {
        System.out.println();
        kurirRepo.save(kurir);
    }

    public boolean updateKurir(final Kurir body) {
        final Optional<Kurir> result = kurirRepo.findById(body.getId());
        if (result != null) {
            try {
                kurirRepo.save(body);
                return true;
            } catch (final Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean deleteById(final String id) {
        final Optional<Kurir> result = kurirRepo.findById(id);
        if (result != null) {
            try {
                kurirRepo.deleteById(id);
                return true;
            } catch (final Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
