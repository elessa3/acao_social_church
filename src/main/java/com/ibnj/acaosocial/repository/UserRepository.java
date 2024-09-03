package com.ibnj.acaosocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibnj.acaosocial.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User>  findByUserEmail(String email);

}