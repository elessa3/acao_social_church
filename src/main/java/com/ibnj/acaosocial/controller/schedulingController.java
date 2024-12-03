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
import com.ibnj.acaosocial.entity.Schedule;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.schedulingRepository;
import com.ibnj.acaosocial.services.schedulingService;

@RestController
@RequestMapping("/scheduling")
public class schedulingController {



     @Autowired
    private schedulingService schedulingService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllscheduling(){
        return new ResponseEntity<> (schedulingService.getAllscheduling(), HttpStatus.OK);
    }

    //Obter pela data especifica
   /* @GetMapping("/scheduling")
    public ResponseEntity<List<scheduling>> getscheduling(@RequestParam LocalDate date){
        List<scheduling> scheduling = schedulingService.getschedulingByvoluntaryes(date) ;
        return ResponseEntity.ok ();
    }*/

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getschedulingById(@PathVariable Long id){
        Schedule scheduling = schedulingService.getschedulingById(id);
        if(null != scheduling){
            return new ResponseEntity<>(scheduling, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(scheduling, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Schedule> savescheduling(@RequestBody Schedule scheduling){
       // scheduling saved = schedulingService.savescheduling(scheduling);
       try {
           return new ResponseEntity<>(schedulingService.savescheduling(scheduling), HttpStatus.CREATED);
           
        } catch(DuplicateException e) {
            return new ResponseEntity<>(schedulingService.savescheduling(scheduling), HttpStatus.CONFLICT);
            
       }
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updatescheduling(@RequestBody Schedule scheduling, @PathVariable Long id){
        return new ResponseEntity<>(schedulingService.updatescheduling(scheduling, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deletescheduling(@PathVariable Long id){
        Schedule scheduling = schedulingService.getschedulingById(id);
        if(null == scheduling){
            return new ResponseEntity<>(scheduling, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(schedulingService.deletescheduling(id), HttpStatus.OK);
        }
    }
    
}
