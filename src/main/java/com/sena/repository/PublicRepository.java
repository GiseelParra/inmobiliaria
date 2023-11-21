package com.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.modelo.Publicacion;

import java.util.List;

@Repository
public interface PublicRepository extends JpaRepository<Publicacion, Integer> {

	List<Publicacion> findByTipoLugar(String TipoLugar);

	List<Publicacion> findByDisponible(String disponible);

	@Query("SELECT p FROM Publicacion p WHERE p.tipoLugar LIKE %?1%" + "OR p.disponible LIKE %?1%"
			+ "OR p.precio LIKE %?1%" + "OR p.Descripcion LIKE %?1%" + "OR p.direccion LIKE %?1%"
			+ "OR p.medida LIKE %?1%")
	public List<Publicacion> findAll(String palbraClave);

}
