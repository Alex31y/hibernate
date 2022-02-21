package com.exampleDB.postgreeDB.service;

import com.exampleDB.postgreeDB.dto.EntitaDTO;
import com.exampleDB.postgreeDB.repo.EntitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EntitaService {
    @Autowired
    private final EntitaRepo entRepo;

    @Autowired
    public EntitaService(EntitaRepo entRepo) {this.entRepo = entRepo;}

    public EntitaDTO getEntByID(Long id){
        return entRepo.getEntByID(id);
    }

    public Long deleteId(Long id){
        return entRepo.deleteEnt(id);
    }

    public Long insert(EntitaDTO e){
        return entRepo.saveAndFlush(e).getId();
    }
}
