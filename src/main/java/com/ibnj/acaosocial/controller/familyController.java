package com.ibnj.acaosocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibnj.acaosocial.entity.family;
import com.ibnj.acaosocial.services.familyService;

public class familyController {

     @Autowired
    private familyService familyService;

    //Obter
    @GetMapping
    public ResponseEntity<List<family>> getAllfamily(){
        return new ResponseEntity<> (familyService.getAllfamily(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<family> getfamilyById(@PathVariable Long id){
        family family = familyService.getfamilyById(id);
        if(null != family){
            return new ResponseEntity<>(family, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(family, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<family> savefamily(@RequestBody family family){
       // family saved = familyService.savefamily(family);
        return new ResponseEntity<>(familyService.savefamily(family), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<family> updatefamily(@RequestBody family family, @PathVariable Long id){
        return new ResponseEntity<>(familyService.updatefamily(family, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<family> deletefamily(@PathVariable Long id){
        family family = familyService.getfamilyById(id);
        if(null == family){
            return new ResponseEntity<>(family, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(familyService.deletefamily(id), HttpStatus.OK);
        }
    }
    
}
