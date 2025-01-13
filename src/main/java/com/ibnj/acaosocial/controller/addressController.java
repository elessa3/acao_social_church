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

import com.ibnj.acaosocial.entity.Address;
import com.ibnj.acaosocial.services.AddressService;

@RestController
@RequestMapping("/{address}")
public class AddressController {


    @Autowired
    private AddressService addressService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        return new ResponseEntity<> (addressService.getAllAddress(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        Address address = addressService.getAddressById(id);
        if(null != address){
            return new ResponseEntity<>(address, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(address, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Long id){
        return new ResponseEntity<>(addressService.updateAddress(address, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Address> deleteAddress(@PathVariable Long id){
        Address address = addressService.getAddressById(id);
        if(null == address){
            return new ResponseEntity<>(address, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
        }
    }
    
}
