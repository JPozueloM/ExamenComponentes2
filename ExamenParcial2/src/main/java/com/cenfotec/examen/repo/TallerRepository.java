package com.cenfotec.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;



public interface TallerRepository extends JpaRepository<Taller, Long>{
	public List<Taller> findByNameContaining(String word);
	public List<Taller> findByCategoria(Categoria categoria);


}
