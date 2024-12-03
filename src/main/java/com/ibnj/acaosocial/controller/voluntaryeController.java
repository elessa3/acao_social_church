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

import com.ibnj.acaosocial.entity.voluntarye;
import com.ibnj.acaosocial.services.voluntaryeService;

@RestController
@RequestMapping("/voluntarye")
public class voluntaryeController {
    

    @Autowired
    private voluntaryeService voluntaryeService;

    //Obter todos
    @GetMapping
    public ResponseEntity<List<voluntarye>> getAllvoluntarye(){
        return new ResponseEntity<> (voluntaryeService.getAllvoluntarye() , HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<voluntarye> getvoluntaryeById(@PathVariable Long id){
        voluntarye voluntarye = voluntaryeService.getvoluntaryeById(id);
        if(null != voluntarye){
            return new ResponseEntity<>(voluntarye, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(voluntarye, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<voluntarye> savevoluntarye(@RequestBody voluntarye voluntarye){
        return new ResponseEntity<>(voluntaryeService.savevoluntarye(voluntarye), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<voluntarye> updatevoluntaryes(@RequestBody voluntarye voluntarye, @PathVariable Long id){
        return new ResponseEntity<>(voluntaryeService.updatevoluntarye(voluntarye, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<voluntarye> deletevoluntarye(@PathVariable Long id){
        voluntarye voluntarye = voluntaryeService.getvoluntaryeById(id);
        if(null == voluntarye){
            return new ResponseEntity<>(voluntarye, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(voluntaryeService.deletvoluntarye(id), HttpStatus.OK);
        }
    }
}
