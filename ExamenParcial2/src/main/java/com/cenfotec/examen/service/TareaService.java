package com.cenfotec.examen.service;

import java.util.List;
import java.util.Optional;

import com.cenfotec.examen.domain.Tarea;

public interface TareaService {

	public void save(Tarea tarea);
	public Optional<Tarea> get(Long id);
	public List<Tarea> getAll();
	public List<Tarea> find(String name);
}
