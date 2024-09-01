package com.ibnj.acaosocial.controller;


import java.util.List;
import java.time.LocalDate;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibnj.acaosocial.entity.Beneficiaires;
import com.ibnj.acaosocial.services.BeneficiairesService;

@RestController
@RequestMapping("/beneficiaires")
public class BeneficiairesController {

    @Autowired
    private BeneficiairesService beneficiairesService;

    //Obter todos
    @GetMapping
    public ResponseEntity<List<Beneficiaires>> getAllBeneficiaires(){
        return new ResponseEntity<> (beneficiairesService.getAllBeneficiaires(), HttpStatus.OK);
    }

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiaires> getBeneficiairesById(@PathVariable Long id){
        Beneficiaires beneficiaires = beneficiairesService.getBeneficiairesById(id);
        if(null != beneficiaires){
            return new ResponseEntity<>(beneficiaires, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(beneficiaires, HttpStatus.NOT_FOUND);
        }
    }
    //Obter pelo code de famille
    @GetMapping("/code_famille")
    public ResponseEntity<List<Beneficiaires>> getBeneficiairesByCodeFamille(@PathVariable String code_famille, String nom_famille){
        List<Beneficiaires> beneficiaires = beneficiairesService.getBeneficiaires_Famille(code_famille, nom_famille);
        
            return new ResponseEntity<>(beneficiaires, HttpStatus.OK);        
        
    }


    //Obter pela data especifica
  // @GetMapping("/horaires")
  /*  public ResponseEntity<List<Beneficiaires>> getHoraires(@RequestParam LocalDate date){
        List<Beneficiaires> horaires = beneficiairesService.getAllBeneficiaires().contains(date) ;
        return ResponseEntity.ok ();
    }*/

    //Salvar
    @PostMapping
    public ResponseEntity<Beneficiaires> saveBeneficiaires(@RequestBody Beneficiaires beneficiaires){
       // Beneficiaires saved = beneficiairesService.saveBeneficiaires(beneficiaires);
        return new ResponseEntity<>(beneficiairesService.saveBeneficiaires(beneficiaires), HttpStatus.CREATED);
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Beneficiaires> updateBeneficiaires(@RequestBody Beneficiaires beneficiaires, @PathVariable Long id){
        
        return new ResponseEntity<>(beneficiairesService.updateBeneficiaires(beneficiaires, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Beneficiaires> deleteBeneficiaires(@PathVariable Long id){
        return new ResponseEntity<>(beneficiairesService.deleteBeneficiaires(id), HttpStatus.OK);
    }

    
}
