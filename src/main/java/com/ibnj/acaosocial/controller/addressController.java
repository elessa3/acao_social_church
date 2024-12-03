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

import com.ibnj.acaosocial.entity.address;
import com.ibnj.acaosocial.services.addressService;

@RestController
@RequestMapping("/{address}")
public class addressController {


    @Autowired
    private addressService addressService;

    //Obter
    @GetMapping
    public ResponseEntity<List<address>> getAlladdress(){
        return new ResponseEntity<> (addressService.getAlladdress(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<address> getaddressById(@PathVariable Long id){
        address address = addressService.getaddressById(id);
        if(null != address){
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(address, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<address> saveaddress(@RequestBody address address){
        return new ResponseEntity<>(addressService.saveaddress(address), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<address> updateaddress(@RequestBody address address, @PathVariable Long id){
        return new ResponseEntity<>(addressService.updateaddress(address, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<address> deleteaddress(@PathVariable Long id){
        address address = addressService.getaddressById(id);
        if(null == address){
            return new ResponseEntity<>(address, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(addressService.deleteaddress(id), HttpStatus.OK);
        }
    }
    
}
