package edu.curso.controllers;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TesteController {
	
	@RequestMapping("/teste")
	public ModelAndView teste(
			@RequestParam("NOME") Optional<String> nome) {
		ModelAndView mv = new ModelAndView("pagina1");
		mv.addObject("MENSAGEM", "Bem vindo " + nome.orElse("Fulano"));
		mv.addObject("DATAATUAL", new Date());
		return mv;
	}

}
