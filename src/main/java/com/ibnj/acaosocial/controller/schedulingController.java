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
import com.ibnj.acaosocial.repository.SchedulingRepository;
import com.ibnj.acaosocial.services.SchedulingService;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {



     @Autowired
    private SchedulingService schedulingService;

    //Obter
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllScheduling(){
        return new ResponseEntity<> (schedulingService.getAllScheduling(), HttpStatus.OK);
    }

    //Obter pela data especifica
   /* @GetMapping("/scheduling")
    public ResponseEntity<List<scheduling>> getscheduling(@RequestParam LocalDate date){
        List<scheduling> scheduling = schedulingService.getschedulingByvoluntaryes(date) ;
        return ResponseEntity.ok ();
    }*/

    //Obter pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getSchedulingById(@PathVariable Long id){
        Schedule scheduling = schedulingService.getSchedulingById(id);
        if(null != scheduling){
            return new ResponseEntity<>(scheduling, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(scheduling, HttpStatus.NOT_FOUND);
        }
    }

    //Salvar
    @PostMapping
    public ResponseEntity<Schedule> saveScheduling(@RequestBody Schedule scheduling){
       // scheduling saved = schedulingService.savescheduling(scheduling);
       try {
           return new ResponseEntity<>(schedulingService.saveScheduling(scheduling), HttpStatus.CREATED);
           
        } catch(DuplicateException e) {
            return new ResponseEntity<>(schedulingService.saveScheduling(scheduling), HttpStatus.CONFLICT);
            
       }
    }

    //Atualizar pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateScheduling(@RequestBody Schedule scheduling, @PathVariable Long id){
        return new ResponseEntity<>(schedulingService.updateScheduling(scheduling, id), HttpStatus.OK);
    }

    //Deletarr pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteScheduling(@PathVariable Long id){
        Schedule scheduling = schedulingService.getSchedulingById(id);
        if(null == scheduling){
            return new ResponseEntity<>(scheduling, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(schedulingService.deleteScheduling(id), HttpStatus.OK);
        }
    }
    
}
