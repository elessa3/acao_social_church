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

import com.ibnj.acaosocial.entity.Volontaire;
import com.ibnj.acaosocial.services.VolontaireService;

@RestController
@RequestMapping("/volontaire")
public class VolontaireController {
    

    @Autowired
    private VolontaireService volontaireService;

    //Obter todos
    @GetMapping
    public ResponseEntity<List<Volontaire>> getAllVolontaire(){
        return new ResponseEntity<> (volontaireService.getAllvolontaire() , HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Volontaire> getVolontaireById(@PathVariable Long id){
        Volontaire volontaire = volontaireService.getvolontaireById(id);
        if(null != volontaire){
            return new ResponseEntity<>(volontaire, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(volontaire, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Volontaire> saveVolontaire(@RequestBody Volontaire volontaire){
        return new ResponseEntity<>(volontaireService.savevolontaire(volontaire), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Volontaire> updateVolontaires(@RequestBody Volontaire volontaire, @PathVariable Long id){
        return new ResponseEntity<>(volontaireService.updatevolontaire(volontaire, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Volontaire> deleteVolontaire(@PathVariable Long id){
        Volontaire volontaire = volontaireService.getvolontaireById(id);
        if(null == volontaire){
            return new ResponseEntity<>(volontaire, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(volontaireService.deletvolontaire(id), HttpStatus.OK);
        }
    }
}
