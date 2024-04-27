package com.example.CC1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CC1.Model.Model;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model, Integer> {

	Optional<Model> findByEmail(String email);

}
