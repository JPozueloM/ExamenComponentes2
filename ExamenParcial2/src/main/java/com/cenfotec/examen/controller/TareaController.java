package com.cenfotec.examen.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.examen.domain.Taller;
import com.cenfotec.examen.domain.Tarea;
import com.cenfotec.examen.service.TallerService;
import com.cenfotec.examen.service.TareaService;

@Controller
public class TareaController {

	@Autowired
	TareaService tareaService;
	
	@Autowired
	TallerService tallerService;
	
	@RequestMapping(value = "/TareaiInsertar/{id}",  method = RequestMethod.GET)
	public String insertarTarea(@PathVariable("id") long id, Model model) {
		model.addAttribute("tarea", new Tarea());
		model.addAttribute("id", id);
		return "TareaInsertar";
	}
	
	@RequestMapping(value = "/TareaiInsertar/{id}",  method = RequestMethod.POST)
	public String insertarAction(@PathVariable("id") long id, Tarea tarea,  BindingResult result, Model model) {
		Optional<Taller> taller = tallerService.get(id);
		tarea.setTaller(taller.get());
		tareaService.save(tarea);
		return "index";
	
}
}
