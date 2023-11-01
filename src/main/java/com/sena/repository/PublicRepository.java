package com.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.modelo.Publicacion;

public interface PublicRepository extends JpaRepository<Publicacion, Integer> {

}
