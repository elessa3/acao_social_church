package com.ibnj.acaosocial.repository;

import java.util.Optional;
import java.util.List;
import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.Beneficiaires;

@Repository
public interface BeneficiairesRepository extends JpaRepository<Beneficiaires, Long>{

    //Encontrar pelo nome e endereco
    Optional<Beneficiaires> findByNameandDN(String  nom, String prenom ,LocalDate date_de_naissance);

    //Para listar os agendados por data
    //List<Beneficiaires> findByscheduling_Date(LocalDate  date); 

    //Para listar beneficiario por familia
    List<Beneficiaires> findByCodefamily(String  code_family, String nom_family);

    
    
} 