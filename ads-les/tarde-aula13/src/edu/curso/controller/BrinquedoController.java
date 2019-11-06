package edu.curso.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.entidade.Brinquedo;
import edu.curso.repository.BrinquedoRepository;

@Controller
public class BrinquedoController {
	
	@Resource(name = "userInfo")
	Usuario u;
	
	@Autowired 
	BrinquedoRepository brinquedoRepository;

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
	
	@RequestMapping("/login")
	public ModelAndView login() { 
		System.out.printf("Usuario atual %s\n", u.getUser());
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/loginController")
	public ModelAndView loginProcess(@RequestParam("username") String user,
			@RequestParam("password") String pass) {
		String page = "error";
		if("admin".equals(user) && "pass".equals(pass)) { 
			page = "principal";
			u.setUser(user);
			u.setPass(pass);
			u.setProfile("admin");
		}
		ModelAndView model = new ModelAndView(page);
		return model;
	}
	
	
	@RequestMapping("/brinquedos")
	public ModelAndView gestaoBrinquedos() {
		List<Brinquedo> lista = new ArrayList<>();
		brinquedoRepository.findAll().iterator().forEachRemaining(lista::add);
		ModelAndView mv = new ModelAndView("brinquedo");
		mv.addObject("brinquedoAtual", new Brinquedo());
		mv.addObject("brinquedoLista", lista);
		return mv;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizarBrinquedos(@ModelAttribute("brinquedoAtual") Brinquedo brinquedoAtual) {
		System.out.println("Atualizar Brinquedo foi executado");
		ModelAndView mv = new ModelAndView("brinquedo");
		brinquedoRepository.save(brinquedoAtual);
		mv.addObject("brinquedoAtual", new Brinquedo());
		List<Brinquedo> lista = new ArrayList<>();
		brinquedoRepository.findAll().iterator().forEachRemaining(lista::add);
		mv.addObject("brinquedoLista", lista);
		return mv;
	}
	
}
