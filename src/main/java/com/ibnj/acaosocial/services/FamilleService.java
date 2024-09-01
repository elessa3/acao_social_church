package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Famille;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.FamilleRepository;

@Service
public class FamilleService {
    
    @Autowired
    private FamilleRepository familleRepository;

    //Lista todos os beneficiarios
    public List<Famille> getAllFamille(){
        return familleRepository.findAll();
    }

    //Lista pelo id
    public Famille getFamilleById(Long id){
        return familleRepository.findById(id).get();
    }

    // fazer um get de beneficiarios com o mesmo codigo de familia para verificar se os beneficiarios estao na mesma familia
/*  public Famille getFamilleByIdAndCode(Long id, String nom, String prenom, String code_famille){
        List<Famille> listeFamilier = familleRepository.findByBeneficiaires_Famille()
*/

    //Salva novo beneficiario
    public Famille saveFamille(Famille famille){
        Optional<Famille> existing = familleRepository.findByNameandCode(famille.getNom_famille(), famille.getBeneficiaires().getCode_famille());
        if (existing.isPresent()) {
            throw new DuplicateException ("Familia ja cadastrada");
        } else {
            return familleRepository.save(famille);
        }
    }

    //Atualiza os dados do beneficiario
    public Famille updateFamille(Famille famille,  Long id){
        Famille familleEnregistre = getFamilleById(id);

        familleEnregistre.setNom_famille(famille.getNom_famille());
        familleEnregistre.setDegre_parente(famille.getDegre_parente());
        familleEnregistre.setBeneficiaires(famille.getBeneficiaires());
        familleEnregistre.setHoraires(famille.getHoraires());

        return familleRepository.save(familleEnregistre);

    }

    //Deleta os dados
    public Famille deleteFamille(Long id){
        familleRepository.deleteById(id);
        return getFamilleById(id);
    }
    
}
