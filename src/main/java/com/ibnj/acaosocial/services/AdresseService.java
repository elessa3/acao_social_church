package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Adresse;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.AdresseRepository;

@Service
public class AdresseService {
    
    @Autowired
    private AdresseRepository adresseRepository;

    //Lista todos os enderecos
    public List<Adresse> getAllAdresse(){
        return adresseRepository.findAll();
    }

    //Lista pelo id
    public Adresse getAdresseById(Long id){
        return adresseRepository.findById(id).get();
    }

    //fazer um get de beneficiarios com o mesmo codigo de familia no mesmo endereco
  /*   public List<Adresse> getAdresseByCodeFamille(){
        List<Adresse> adresse = beneficiairesRepository.findByCodeFamille(String code_famille, String nom_famille){
            if (adresse.equals(?)) {
                return beneficiairesRepository.findById(id).get();
            }
        }
    }*/

    //fazer uma verificacao se no mesmo endereco tem mais de um codigo de familia

    //Salva novo beneficiario
    public Adresse saveAdresse(Adresse adresse){
        Optional<Adresse> existing = adresseRepository.findByAdresseComplete(
            adresse.getNombre(), adresse.getRue_avenue(), adresse.getComplement() , adresse.getCommune(), adresse.getCode_postal());
            if(existing.isPresent()){
                throw new DuplicateException("Endereco ja cadastrado");
            } else {

                return adresseRepository.save(adresse);
            }
    }

    //Atualiza os dados do beneficiario
    public Adresse updateAdresse(Adresse adresse,  Long id){
        Adresse adresseEnregistre = getAdresseById(id);

        adresseEnregistre.setRue_avenue(adresse.getRue_avenue());
        adresseEnregistre.setNombre(adresse.getNombre());
        adresseEnregistre.setComplement(adresse.getComplement());
        adresseEnregistre.setCommune(adresse.getCommune());
        adresseEnregistre.setCode_postal(adresse.getCode_postal());
        
        return adresseRepository.save(adresseEnregistre);

    }

    //Deleta os dados
    public Adresse deleteAdresse(Long id){
        adresseRepository.deleteById(id);
        return getAdresseById(id);
    }
    
}
