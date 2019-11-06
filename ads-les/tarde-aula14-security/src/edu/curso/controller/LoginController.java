package edu.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {	
	@RequestMapping("/login")
	public ModelAndView login() { 
		return new ModelAndView("login");
	}
	
	@RequestMapping("/principal")
	public ModelAndView principal() {
		return new ModelAndView("principal");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/gerenciar")
	public ModelAndView gerenciar() {
		return new ModelAndView("gerenciar");
	}
	
	@RequestMapping(value = {"/loginController"}, 
			method = {RequestMethod.POST})
	public ModelAndView loginController(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		return new ModelAndView("principal");
	}

}
