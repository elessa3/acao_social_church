package com.ibnj.acaosocial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Address;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    //Lista todos os enderecos
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    //Lista pelo id
    public Address getAddressById(Long id){
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
    public Address saveAddress(Address address){
        Optional<Address> existing = addressRepository.findByAddressComplete(
            address.getname(), address.getstreet(), address.getComplement() , address.getCommune(), address.getCode_postal());
            if(existing.isPresent()){
                throw new DuplicateException("Address already registered");
            } else {

                return addressRepository.save(address);
            }
    }

    //Atualiza os dados do beneficiario
    public Address updateAddress(Address address,  Long id){
        Address addressEnregistry = getAddressById(id);

        addressEnregistry.setstreet(address.getstreet());
        addressEnregistry.setname(address.getname());
        addressEnregistry.setComplement(address.getComplement());
        addressEnregistry.setCommune(address.getCommune());
        addressEnregistry.setCode_postal(address.getCode_postal());
        
        return addressRepository.save(addressEnregistry);

    }

    //Deleta os dados
    public Address deleteAddress(Long id){
        addressRepository.deleteById(id);
        return getAddressById(id);
    }
    
}
