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

import com.ibnj.acaosocial.entity.Family;
import com.ibnj.acaosocial.services.FamilyService;

public class FamilyController {

     @Autowired
    private FamilyService familyService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Family>> getAllFamily(){
        return new ResponseEntity<> (familyService.getAllFamily(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Family> getFamilyById(@PathVariable Long id){
        Family family = familyService.getFamilyById(id);
        if(null != family){
            return new ResponseEntity<>(family, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(family, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Family> saveFamily(@RequestBody Family family){
       // family saved = familyService.savefamily(family);
        return new ResponseEntity<>(familyService.saveFamily(family), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Family> updateFamily(@RequestBody Family family, @PathVariable Long id){
        return new ResponseEntity<>(familyService.updateFamily(family, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Family> deleteFamily(@PathVariable Long id){
        Family family = familyService.getFamilyById(id);
        if(null == family){
            return new ResponseEntity<>(family, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(familyService.deleteFamily(id), HttpStatus.OK);
        }
    }
    
}
