package com.ibnj.acaosocial.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.voluntarye;

@Repository
public interface voluntaryeRepository extends JpaRepository<voluntarye, Long> {
    Optional<voluntarye> findByNomandPrenom (String nom, String prenom);
}
