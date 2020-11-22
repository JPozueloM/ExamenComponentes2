package com.cenfotec.examen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cenfotec.examen.domain.Categoria;
import com.cenfotec.examen.domain.Taller;
import com.cenfotec.examen.service.CategoriaService;
import com.cenfotec.examen.service.TallerService;


@Controller
public class TallerController {
	
	@Autowired
	TallerService tallerService;
	
	@Autowired
	CategoriaService categoriaService;


	
	@RequestMapping("/")
	public String home(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/TallerInsertar",  method = RequestMethod.GET)
	public String insertarTaller(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute(new Taller());
		return "TallerInsertar";
	}
	
	@RequestMapping(value ="/TallerInsertar", method = RequestMethod.POST)
	public String insertAction(Taller taller, BindingResult result, Model model) {
		Categoria categoria = categoriaService.get(taller.getIdCategoria()).get();
		taller.setCategoria(categoria);
		tallerService.save(taller);
		return "index";
	}
	
	
	@RequestMapping("/TallerListar")
	public String listar(Model model) {
		model.addAttribute("taller",tallerService.getAll());
		return "TallerListar";
	}
	
	@RequestMapping("/TallerEditar/{id}")
	public String editarTaller(Model model, @PathVariable("id") long id) {
		Taller taller = tallerService.get(id).get();
		taller.setIdCategoria((int) taller.getCategoria().getId());
		model.addAttribute("categorias", categoriaService.getAll());
		model.addAttribute("taller", taller);
		return "TallerEditar";
	}
	
	@RequestMapping(value="TallerEditar/{id}",  method = RequestMethod.POST)
	public String saveEdition(Taller taller, Model model, @PathVariable long id) {
		tallerService.save(taller);
		return "index";
	}
	
	@RequestMapping("/TallerByCategoria")
	public String listarCategoria(Model model) {
		model.addAttribute("categorias", categoriaService.getAll());
		return "TallerByCategoria";
	} 

	@GetMapping(value = "/TallerByCategoria/{categoriaId}")
	public String listarKeyword(@PathVariable("categoriaId") long categoriaId, Model model) {
		Categoria cat = categoriaService.get(categoriaId).get();

		model.addAttribute("taller", tallerService.findByCategoria(cat));
		return "workshop/listar";
	}
}
