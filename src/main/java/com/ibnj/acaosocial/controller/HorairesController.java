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
import com.ibnj.acaosocial.entity.Horaires;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.HorairesRepository;
import com.ibnj.acaosocial.services.HorairesService;

@RestController
@RequestMapping("/horaires")
public class HorairesController {



     @Autowired
    private HorairesService horairesService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Horaires>> getAllHoraires(){
        return new ResponseEntity<> (horairesService.getAllHoraires(), HttpStatus.OK);
    }

    //Obter pela data especifica
   /* @GetMapping("/horaires")
    public ResponseEntity<List<Horaires>> getHoraires(@RequestParam LocalDate date){
        List<Horaires> horaires = horairesService.getHorairesByVolontaires(date) ;
        return ResponseEntity.ok ();
    }*/

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Horaires> getHorairesById(@PathVariable Long id){
        Horaires horaires = horairesService.getHorairesById(id);
        if(null != horaires){
            return new ResponseEntity<>(horaires, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(horaires, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Horaires> saveHoraires(@RequestBody Horaires horaires){
       // Horaires saved = HorairesService.saveHoraires(Horaires);
       try {
           return new ResponseEntity<>(horairesService.saveHoraires(horaires), HttpStatus.CREATED);
           
        } catch(DuplicateException e) {
            return new ResponseEntity<>(horairesService.saveHoraires(horaires), HttpStatus.CONFLICT);
            
       }
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Horaires> updateHoraires(@RequestBody Horaires horaires, @PathVariable Long id){
        return new ResponseEntity<>(horairesService.updateHoraires(horaires, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Horaires> deleteHoraires(@PathVariable Long id){
        Horaires horaires = horairesService.getHorairesById(id);
        if(null == horaires){
            return new ResponseEntity<>(horaires, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(horairesService.deleteHoraires(id), HttpStatus.OK);
        }
    }
    
}
