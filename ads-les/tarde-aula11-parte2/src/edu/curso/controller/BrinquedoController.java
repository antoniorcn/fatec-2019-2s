package edu.curso.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.entidade.Brinquedo;

@Controller
public class BrinquedoController {

	@ModelAttribute("categorias")
	public List<String> categorias() {
		 List<String> categorias = new ArrayList<>();
		 categorias.add("Esportes");
		 categorias.add("Bonecos");
		 categorias.add("Coleções");
		 categorias.add("Bolas");
		 categorias.add("Jogos de tauleiro");
		 categorias.add("Jogos eletrônicos");
		 return categorias;
	}
	
	
	@RequestMapping("/brinquedos")
	public ModelAndView gestaoBrinquedos() { 
		Brinquedo b = new Brinquedo();
		b.setId(1);
		b.setNome("Bola de Basquete");
		b.setCategoria("Esporte");
		b.setDataCompra(new Date());
		b.setFabricante("Spawding");
		
		ModelAndView mv = new ModelAndView("brinquedo");
		mv.addObject("brinquedoAtual", b);
		
		return mv;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizarBrinquedos() {
		System.out.println("Atualizar Brinquedo foi executado");
		ModelAndView mv = new ModelAndView("brinquedo");
		mv.addObject("brinquedoAtual", new Brinquedo());
		return mv;
	}
	
}
