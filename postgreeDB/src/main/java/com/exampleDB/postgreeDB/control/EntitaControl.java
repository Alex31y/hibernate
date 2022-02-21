package com.exampleDB.postgreeDB.control;

import com.exampleDB.postgreeDB.dto.EntitaDTO;
import com.exampleDB.postgreeDB.service.EntitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/ent")

public class EntitaControl{

    @Autowired
    private final EntitaService entService;

    @Autowired
    public EntitaControl(EntitaService entService){
        this.entService = entService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EntitaDTO> findId(@PathVariable("id") Long id){
        try{
            EntitaDTO found = entService.getEntByID(id);
            return new ResponseEntity<>(found, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/del/{id}")
    public ResponseEntity<Long> deleteId(@PathVariable("id") Long id){
        try{
            Long result = entService.deleteId(id);
            System.out.println("//RESULT = " + result + " //");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("insert")
    public ResponseEntity<Long> insert(@RequestBody EntitaDTO e){
        try{
            Long id = entService.insert(e);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}