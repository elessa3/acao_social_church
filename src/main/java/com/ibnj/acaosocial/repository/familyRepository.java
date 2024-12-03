package com.ibnj.acaosocial.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.family;

@Repository
public interface familyRepository extends JpaRepository<family, Long> {

    Optional<family> findByNameandCode(String nom_family, String code_family);

    //Para listar os integrantes da familia
    List<family> findByBeneficiaires_family(Long id, String  nom, String prenom, String code_family);

    
}
