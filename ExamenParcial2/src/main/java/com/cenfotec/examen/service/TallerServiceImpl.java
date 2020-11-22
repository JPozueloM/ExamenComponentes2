package com.cenfotec.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;
import com.cenfotec.examen.repo.TallerRepository;


@Service
public class TallerServiceImpl implements TallerService{

	
	@Autowired
	TallerRepository repo;
	
	@Override
	public void save(Taller taller) {
		repo.save(taller);
		
	}

	@Override
	public Optional<Taller> get(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Taller> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Taller> find(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public List<Taller> findByCategoria(Categoria categoria) {
		List<Taller> taller = repo.findByCategoria(categoria);
		return taller;
	}

}
