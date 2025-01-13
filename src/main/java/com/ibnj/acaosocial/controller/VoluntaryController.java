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

import com.ibnj.acaosocial.entity.Voluntary;
import com.ibnj.acaosocial.services.VoluntaryService;

@RestController
@RequestMapping("/voluntary")
public class VoluntaryController {
    

    @Autowired
    private VoluntaryService voluntaryService;

    //Obter todos
    @GetMapping
    public ResponseEntity<List<Voluntary>> getAllVoluntary(){
        return new ResponseEntity<> (voluntaryService.getAllVoluntary() , HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Voluntary> getVoluntaryById(@PathVariable Long id){
        Voluntary voluntary = voluntaryService.getVoluntaryById(id);
        if(null != voluntary){
            return new ResponseEntity<>(voluntary, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(voluntary, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Voluntary> saveVoluntary(@RequestBody Voluntary voluntary){
        return new ResponseEntity<>(voluntaryService.saveVoluntary(voluntary), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Voluntary> updateVoluntary(@RequestBody Voluntary voluntary, @PathVariable Long id){
        return new ResponseEntity<>(voluntaryService.updateVoluntary(voluntary, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Voluntary> deleteVoluntary(@PathVariable Long id){
        Voluntary voluntary = voluntaryService.getVoluntaryById(id);
        if(null == voluntary){
            return new ResponseEntity<>(voluntary, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(voluntaryService.deletVoluntary(id), HttpStatus.OK);
        }
    }
}
