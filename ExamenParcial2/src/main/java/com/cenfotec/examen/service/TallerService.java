package com.cenfotec.examen.service;

import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;
import java.util.List;
import java.util.Optional;

public interface TallerService {

	public void save(Taller taller);
	public Optional<Taller> get(Long id);
	public List<Taller> getAll();
	public List<Taller> find(String name);
	public  List<Taller> findByCategoria(Categoria categoria);
	
}
