package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Family;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.FamilyRepository;

@Service
public class FamilyService {
    
    @Autowired
    private FamilyRepository familyRepository;

    //Lista todos os beneficiarios
    public List<Family> getAllFamily(){
        return familyRepository.findAll();
    }

    //Lista pelo id
    public Family getFamilyById(Long id){
        return familyRepository.findById(id).get();
    }

    // fazer um get de beneficiarios com o mesmo codigo de familia para verificar se os beneficiarios estao na mesma familia
/*  public family getfamilyByIdAndCode(Long id, String nom, String prenom, String code_family){
        List<family> listeFamilier = familyRepository.findByBeneficiaires_family()
*/

    //Salva novo beneficiario
    public Family saveFamily(Family family){
        Optional<Family> existing = familyRepository.findByNameandCode(family.getNom_family(), family.getBeneficiaires().getCode_family());
        if (existing.isPresent()) {
            throw new DuplicateException ("Family already registered");
        } else {
            return familyRepository.save(family);
        }
    }

    //Atualiza os dados do beneficiario
    public Family updateFamily(Family family,  Long id){
        Family familyEnregistry = getFamilyById(id);

        familyEnregistry.setNom_family(family.getNom_family());
        familyEnregistry.setDegre_parente(family.getDegre_parente());
        familyEnregistry.setBeneficiaires(family.getBeneficiaires());
        familyEnregistry.setscheduling(family.getscheduling());

        return familyRepository.save(familyEnregistry);

    }

    //Deleta os dados
    public Family deleteFamily(Long id){
        familyRepository.deleteById(id);
        return getFamilyById(id);
    }
    
}
