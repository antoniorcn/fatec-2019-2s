package edu.curso.controller;

import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeuController {
	
	@RequestMapping("/ola")
	public String helloWorld() {
		System.out.println("Controller Ola Executado");
		return "ola";
	}
	
	@RequestMapping("/msg")
	public ModelAndView msg() {
		System.out.println("Controller Msg Executado");
		ModelAndView model = new ModelAndView("msg");
		model.addObject("TEXTO", "Este texto veio do controller");
		return model;
	}

}
