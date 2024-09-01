package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Volontaire;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.VolontaireRepository;

@Service
public class VolontaireService {
    
    @Autowired
    private VolontaireRepository volontaireRepository;

    //Lista todos os beneficiarios
    public List<Volontaire> getAllvolontaire(){
        return volontaireRepository.findAll();
    }

    //Lista pelo id
    public Volontaire getvolontaireById(Long id){
        return volontaireRepository.findById(id).get();
    }

    //Salva novo beneficiario
    public Volontaire savevolontaire(Volontaire volontaire){
        Optional<Volontaire> existing = volontaireRepository.findByNomandPrenom(volontaire.getNom(), volontaire.getPrenom());
        if(existing.isPresent()){
            throw new DuplicateException ("Voluntario ja cadastrado");
        } else {
            return volontaireRepository.save(volontaire);
        }
    }

    //Atualiza os dados do beneficiario
    public Volontaire updatevolontaire(Volontaire volontaire,  Long id){
        Volontaire volontaireEnregistre = getvolontaireById(id);

        volontaireEnregistre.setNom(volontaire.getNom());
        volontaireEnregistre.setPrenom(volontaire.getPrenom());
        volontaireEnregistre.setTelephone(volontaire.getTelephone());
        volontaireEnregistre.setHoraires(volontaire.getHoraires());

        return volontaireRepository.save(volontaireEnregistre);

    }

    //Deleta os dados
    public Volontaire deletvolontaire(Long id){
        volontaireRepository.deleteById(id);
        return getvolontaireById(id);
    }
}
