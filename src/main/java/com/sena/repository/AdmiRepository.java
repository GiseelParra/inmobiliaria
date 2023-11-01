package com.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.modelo.Administrador;

public interface AdmiRepository extends JpaRepository<Administrador, Integer> {

}
