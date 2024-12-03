package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.address;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.addressRepository;

@Service
public class addressService {
    
    @Autowired
    private addressRepository addressRepository;

    //Lista todos os enderecos
    public List<address> getAlladdress(){
        return addressRepository.findAll();
    }

    //Lista pelo id
    public address getaddressById(Long id){
        return addressRepository.findById(id).get();
    }

    //fazer um get de beneficiarios com o mesmo codigo de familia no mesmo endereco
  /*   public List<address> getaddressByCodefamily(){
        List<address> address = beneficiairesRepository.findByCodefamily(String code_family, String nom_family){
            if (address.equals(?)) {
                return beneficiairesRepository.findById(id).get();
            }
        }
    }*/

    //fazer uma verificacao se no mesmo endereco tem mais de um codigo de familia

    //Salva novo beneficiario
    public address saveaddress(address address){
        Optional<address> existing = addressRepository.findByaddressComplete(
            address.getNombre(), address.getRue_avenue(), address.getComplement() , address.getCommune(), address.getCode_postal());
            if(existing.isPresent()){
                throw new DuplicateException("Endereco ja cadastrado");
            } else {

                return addressRepository.save(address);
            }
    }

    //Atualiza os dados do beneficiario
    public address updateaddress(address address,  Long id){
        address addressEnregistre = getaddressById(id);

        addressEnregistre.setRue_avenue(address.getRue_avenue());
        addressEnregistre.setNombre(address.getNombre());
        addressEnregistre.setComplement(address.getComplement());
        addressEnregistre.setCommune(address.getCommune());
        addressEnregistre.setCode_postal(address.getCode_postal());
        
        return addressRepository.save(addressEnregistre);

    }

    //Deleta os dados
    public address deleteaddress(Long id){
        addressRepository.deleteById(id);
        return getaddressById(id);
    }
    
}
