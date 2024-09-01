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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibnj.acaosocial.entity.Adresse;
import com.ibnj.acaosocial.services.AdresseService;

@RestController
@RequestMapping("/{adresse}")
public class AdresseController {


    @Autowired
    private AdresseService adresseService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Adresse>> getAllAdresse(){
        return new ResponseEntity<> (adresseService.getAllAdresse(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Adresse> getAdresseById(@PathVariable Long id){
        Adresse adresse = adresseService.getAdresseById(id);
        if(null != adresse){
            return new ResponseEntity<>(adresse, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(adresse, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Adresse> saveAdresse(@RequestBody Adresse adresse){
        return new ResponseEntity<>(adresseService.saveAdresse(adresse), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Adresse> updateAdresse(@RequestBody Adresse adresse, @PathVariable Long id){
        return new ResponseEntity<>(adresseService.updateAdresse(adresse, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Adresse> deleteAdresse(@PathVariable Long id){
        Adresse adresse = adresseService.getAdresseById(id);
        if(null == adresse){
            return new ResponseEntity<>(adresse, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(adresseService.deleteAdresse(id), HttpStatus.OK);
        }
    }
    
}
