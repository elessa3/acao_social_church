package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Voluntary;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.VoluntaryRepository;

@Service
public class VoluntaryService {
    
    @Autowired
    private VoluntaryRepository voluntaryRepository;

    //Lista todos os beneficiarios
    public List<Voluntary> getAllVoluntary(){
        return voluntaryRepository.findAll();
    }

    //Lista pelo id
    public Voluntary getVoluntaryById(Long id){
        return voluntaryRepository.findById(id).get();
    }

    //Salva novo beneficiario
    public Voluntary saveVoluntary(Voluntary voluntary){
        Optional<Voluntary> existing = voluntaryRepository.findByNomandPrenom(voluntary.getNom(), voluntary.getPrenom());
        if(existing.isPresent()){
            throw new DuplicateException ("Voluntary already registered");
        } else {
            return voluntaryRepository.save(voluntary);
        }
    }

    //Atualiza os dados do beneficiario
    public Voluntary updateVoluntary(Voluntary voluntary,  Long id){
        Voluntary voluntaryEnregistry = getVoluntaryById(id);

        voluntaryEnregistry.setNom(voluntary.getNom());
        voluntaryEnregistry.setPrenom(voluntary.getPrenom());
        voluntaryEnregistry.setTelephone(voluntary.getTelephone());
        voluntaryEnregistry.setscheduling(voluntary.getscheduling());

        return voluntaryRepository.save(voluntaryEnregistry);

    }

    //Deleta os dados
    public Voluntary deletVoluntary(Long id){
        voluntaryRepository.deleteById(id);
        return getVoluntaryById(id);
    }
}
