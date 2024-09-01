package com.ibnj.acaosocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    Optional<Adresse> findByAdresseComplete(Long nombre, String rue_avenue, String complement, String commune, Long code_postal);

}
