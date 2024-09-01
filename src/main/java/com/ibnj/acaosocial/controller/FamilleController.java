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

import com.ibnj.acaosocial.entity.Famille;
import com.ibnj.acaosocial.services.FamilleService;

public class FamilleController {

     @Autowired
    private FamilleService familleService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Famille>> getAllFamille(){
        return new ResponseEntity<> (familleService.getAllFamille(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Famille> getFamilleById(@PathVariable Long id){
        Famille famille = familleService.getFamilleById(id);
        if(null != famille){
            return new ResponseEntity<>(famille, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(famille, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Famille> saveFamille(@RequestBody Famille famille){
       // Famille saved = FamilleService.saveFamille(Famille);
        return new ResponseEntity<>(familleService.saveFamille(famille), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Famille> updateFamille(@RequestBody Famille famille, @PathVariable Long id){
        return new ResponseEntity<>(familleService.updateFamille(famille, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Famille> deleteFamille(@PathVariable Long id){
        Famille famille = familleService.getFamilleById(id);
        if(null == famille){
            return new ResponseEntity<>(famille, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(familleService.deleteFamille(id), HttpStatus.OK);
        }
    }
    
}
