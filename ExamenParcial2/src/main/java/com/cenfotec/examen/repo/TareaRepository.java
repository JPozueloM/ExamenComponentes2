package com.cenfotec.examen.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.examen.domain.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{
	public List<Tarea> findByNameContaining(String word);
}
