package edu.curso.controller;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeuController {
	
	@RequestMapping("/ola")
	public String helloWorld() { 
		return "ola";
	}
	
	@RequestMapping("/msg")
	public ModelAndView msg() { 
		return new ModelAndView("msg", "TEXTO", "Este texto veio do controller");
	}

}
