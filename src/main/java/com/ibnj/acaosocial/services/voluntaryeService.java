package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.voluntarye;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.voluntaryeRepository;

@Service
public class voluntaryeService {
    
    @Autowired
    private voluntaryeRepository voluntaryeRepository;

    //Lista todos os beneficiarios
    public List<voluntarye> getAllvoluntarye(){
        return voluntaryeRepository.findAll();
    }

    //Lista pelo id
    public voluntarye getvoluntaryeById(Long id){
        return voluntaryeRepository.findById(id).get();
    }

    //Salva novo beneficiario
    public voluntarye savevoluntarye(voluntarye voluntarye){
        Optional<voluntarye> existing = voluntaryeRepository.findByNomandPrenom(voluntarye.getNom(), voluntarye.getPrenom());
        if(existing.isPresent()){
            throw new DuplicateException ("Voluntario ja cadastrado");
        } else {
            return voluntaryeRepository.save(voluntarye);
        }
    }

    //Atualiza os dados do beneficiario
    public voluntarye updatevoluntarye(voluntarye voluntarye,  Long id){
        voluntarye voluntaryeEnregistre = getvoluntaryeById(id);

        voluntaryeEnregistre.setNom(voluntarye.getNom());
        voluntaryeEnregistre.setPrenom(voluntarye.getPrenom());
        voluntaryeEnregistre.setTelephone(voluntarye.getTelephone());
        voluntaryeEnregistre.setscheduling(voluntarye.getscheduling());

        return voluntaryeRepository.save(voluntaryeEnregistre);

    }

    //Deleta os dados
    public voluntarye deletvoluntarye(Long id){
        voluntaryeRepository.deleteById(id);
        return getvoluntaryeById(id);
    }
}
