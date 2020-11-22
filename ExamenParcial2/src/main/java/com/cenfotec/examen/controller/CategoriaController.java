package com.cenfotec.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;
import com.cenfotec.examen.service.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping(value = "/CategoriaInsertar",  method = RequestMethod.GET)
	public String insertarCategoria(Model model) {
		model.addAttribute("categoria",new Categoria());
		return "CategoriaInsertar";
	}
	
	@RequestMapping(value ="/CategoriaInsertar", method = RequestMethod.POST)
	public String insertAction(Categoria categoria, BindingResult result, Model model) {
		categoriaService.save(categoria);
		return "index";
	}
}
