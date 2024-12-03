package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.family;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.familyRepository;

@Service
public class familyService {
    
    @Autowired
    private familyRepository familyRepository;

    //Lista todos os beneficiarios
    public List<family> getAllfamily(){
        return familyRepository.findAll();
    }

    //Lista pelo id
    public family getfamilyById(Long id){
        return familyRepository.findById(id).get();
    }

    // fazer um get de beneficiarios com o mesmo codigo de familia para verificar se os beneficiarios estao na mesma familia
/*  public family getfamilyByIdAndCode(Long id, String nom, String prenom, String code_family){
        List<family> listeFamilier = familyRepository.findByBeneficiaires_family()
*/

    //Salva novo beneficiario
    public family savefamily(family family){
        Optional<family> existing = familyRepository.findByNameandCode(family.getNom_family(), family.getBeneficiaires().getCode_family());
        if (existing.isPresent()) {
            throw new DuplicateException ("Familia ja cadastrada");
        } else {
            return familyRepository.save(family);
        }
    }

    //Atualiza os dados do beneficiario
    public family updatefamily(family family,  Long id){
        family familyEnregistre = getfamilyById(id);

        familyEnregistre.setNom_family(family.getNom_family());
        familyEnregistre.setDegre_parente(family.getDegre_parente());
        familyEnregistre.setBeneficiaires(family.getBeneficiaires());
        familyEnregistre.setscheduling(family.getscheduling());

        return familyRepository.save(familyEnregistre);

    }

    //Deleta os dados
    public family deletefamily(Long id){
        familyRepository.deleteById(id);
        return getfamilyById(id);
    }
    
}
