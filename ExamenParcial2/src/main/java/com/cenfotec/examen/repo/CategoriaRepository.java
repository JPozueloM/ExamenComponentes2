package com.cenfotec.examen.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;
import com.cenfotec.examen.domain.Tarea;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public List<Categoria> findByNameContaining(String word);

}
