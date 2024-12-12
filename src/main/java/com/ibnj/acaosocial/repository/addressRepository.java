package com.ibnj.acaosocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibnj.acaosocial.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByAddressComplete(Long name, String street, String complement, String commune, Long code_postal);

}
