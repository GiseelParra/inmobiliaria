package com.sena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.modelo.Publicacion;
import java.util.List;



@Repository
public interface PublicRepository extends JpaRepository<Publicacion, Integer> {
	
	
	List<Publicacion> findByTipoLugar(String TipoLugar);
		
}
