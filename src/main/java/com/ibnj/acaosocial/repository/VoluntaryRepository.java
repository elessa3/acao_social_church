package com.ibnj.acaosocial.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.Voluntary;

@Repository
public interface VoluntaryRepository extends JpaRepository<Voluntary, Long> {
    Optional<Voluntary> findByNomandPrenom (String nom, String prenom);
}
