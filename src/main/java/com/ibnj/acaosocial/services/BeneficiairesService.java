package com.ibnj.acaosocial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.dto.BeneficiairesDTO;
import com.ibnj.acaosocial.entity.Beneficiaires;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.BeneficiairesRepository;

@Service
public class BeneficiairesService {

    @Autowired
    private BeneficiairesRepository beneficiairesRepository;

    //Lista todos os beneficiarios
    public List<Beneficiaires> getAllBeneficiaires(){
        return beneficiairesRepository.findAll();
    }

    //Lista pelo id
    public Beneficiaires getBeneficiairesById(Long id){
        return beneficiairesRepository.findById(id).get();
    }

    //Metodo que busca o beneficiario por familia usando DTO
   /* public List<BeneficiairesDTO> getBeneficiaires_Famille(Long id) {
        List<Beneficiaires> listeBeneficiaires = beneficiairesRepository.findAll();
        List<BeneficiairesDTO> listeBeneficiairesDTO = new ArrayList<>();

        for(Beneficiaires beneficiaires : listeBeneficiaires){
            BeneficiairesDTO beneficiairesDTO = toDTO(beneficiaires);
            listeBeneficiairesDTO.add(beneficiairesDTO);
        }
        //UTILIZAR DTO PARA VALIDAR O METODO
               return beneficiairesRepository.findByCodeFamille(null, null);
    }*/

    //Metodo facilitado para listar beneficiarios pelo codigo da familia
    public List<Beneficiaires> getBeneficiaires_Famille(String code_famille, String nom_famille){
              
        return beneficiairesRepository.findByCodeFamille(code_famille, nom_famille);
    }

    //Salva novo beneficiario 
    public Beneficiaires saveBeneficiaires(Beneficiaires beneficiaires){
        //Validacao de duplicidade de cadastro
        Optional<Beneficiaires> existing = beneficiairesRepository.findByNameandDN  (
            beneficiaires.getNom(), beneficiaires.getPrenom(), beneficiaires.getDate_de_naissance());
        if(existing.isPresent()){
            throw new DuplicateException("Beneficiario ja cadastrado");
        } else{

            return beneficiairesRepository.save(beneficiaires);
        }
        
    }

    //Atualiza os dados do beneficiario
    public Beneficiaires updateBeneficiaires(Beneficiaires beneficiaires,  Long id){
        Beneficiaires beneficiairesEnregistre = getBeneficiairesById(id);

        beneficiairesEnregistre.setNom(beneficiaires.getNom());
        beneficiairesEnregistre.setPrenom(beneficiaires.getPrenom());
        beneficiairesEnregistre.setTelephone(beneficiaires.getTelephone());
        beneficiairesEnregistre.setMail(beneficiaires.getMail());
        beneficiairesEnregistre.setDate_de_naissance(beneficiaires.getDate_de_naissance());
        beneficiairesEnregistre.setFamilier(beneficiaires.getFamilier());
        beneficiairesEnregistre.setAdresse(beneficiaires.getAdresse());
        beneficiairesEnregistre.setCode_famille(beneficiaires.getCode_famille());

        return beneficiairesRepository.save(beneficiairesEnregistre);

    }

    //Deleta os dados
    public Beneficiaires deleteBeneficiaires(Long id){
        beneficiairesRepository.deleteById(id);
        return getBeneficiairesById(id);
    }



    //metodo para converter de entidade para DTO e vice versa

    private Beneficiaires toEntidade(BeneficiairesDTO beneficiairesDTO){
        Beneficiaires beneficiaires = new Beneficiaires();

        beneficiaires.setNom(beneficiairesDTO.getNom());
        beneficiaires.setPrenom(beneficiairesDTO.getPrenom());
        beneficiaires.setDate_de_naissance(beneficiairesDTO.getDate_de_naissance());
        beneficiaires.setTelephone(beneficiairesDTO.getTelephone());
        beneficiaires.setMail(beneficiairesDTO.getMail());
        beneficiaires.setCode_famille(beneficiairesDTO.getCode_famille());
    
        return beneficiaires;    
    }
    private BeneficiairesDTO toDTO(Beneficiaires beneficiaires){
        BeneficiairesDTO beneficiairesDTO = new BeneficiairesDTO();

        beneficiairesDTO.setNom(beneficiaires.getNom());
        beneficiairesDTO.setPrenom(beneficiaires.getPrenom());
        beneficiairesDTO.setDate_de_naissance(beneficiaires.getDate_de_naissance());
        beneficiairesDTO.setTelephone(beneficiaires.getTelephone());
        beneficiairesDTO.setMail(beneficiaires.getMail());
        beneficiairesDTO.setCode_famille(beneficiaires.getCode_famille());

        return beneficiairesDTO;
    }
    
}
