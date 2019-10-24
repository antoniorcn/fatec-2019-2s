package edu.curso.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.entidades.Entrega;
import edu.curso.repository.EntregaRepository;

@Controller
public class EntregaController {
	
	@Autowired
	EntregaRepository entregaRepository;
	
	@ModelAttribute("status")
	public List<String> status() { 
		List<String> status = new ArrayList<>();
		status.add("Aguardando a Entrega");
		status.add("Tentativa de Entrega 1");
		status.add("Tentativa de Entrega 2");
		status.add("Tentativa de Entrega 3");
		status.add("Parado em Curitiba");
		status.add("Greve dos Correios");
		status.add("Cliente Recusou a Entrega");
		return status;
	}
	
	@RequestMapping("/entregas")
	public ModelAndView entregas() { 
		ModelAndView mv = new ModelAndView("entrega");
		Iterable<Entrega> iter = entregaRepository.findAll();
		Entrega e = new Entrega();
		e.setId(2);
		e.setDestino("Praça da Republica");
		e.setOrigem("Fatec Zona Leste");
		
		mv.addObject("entrega", e);
		mv.addObject("lista", iter);
		return mv;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView salvar(@ModelAttribute("entrega") Entrega e) {
		System.out.format("Origem: %s   Destino: %s", e.getOrigem(), e.getDestino());
		entregaRepository.save(e);
		ModelAndView mv = new ModelAndView("entrega");
		mv.addObject("entrega", new Entrega());
		return mv;
	}

}
