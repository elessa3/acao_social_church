package com.ibnj.acaosocial.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.Famille;

@Repository
public interface FamilleRepository extends JpaRepository<Famille, Long> {

    Optional<Famille> findByNameandCode(String nom_famille, String code_famille);

    //Para listar os integrantes da familia
    List<Famille> findByBeneficiaires_Famille(Long id, String  nom, String prenom, String code_famille);

    
}
