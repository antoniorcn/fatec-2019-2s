package edu.curso.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.curso.entidade.Usuario;

@Controller
public class LoginController {
	@Resource(name = "userInfo")
	private Usuario user;
	
	@RequestMapping("/login")
	public ModelAndView login() { 
		return new ModelAndView("login");
	}
	
	@RequestMapping("/principal")
	public ModelAndView principal() {
		String destino = "login";
		if ("admin".equals(user.getProfile())) {
			destino = "principal";
		}
		return new ModelAndView(destino);
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		user.setProfile("");
		user.setUsername("");
		user.setPassword("");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = {"/loginController"}, 
			method = {RequestMethod.POST})
	public ModelAndView loginController(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		String destino = "erro";
		if ("admin".equals(username) && "pass".equals(password)) {
			destino = "principal";
			user.setUsername(username);
			user.setPassword(password);
			user.setProfile("admin");
		}
		return new ModelAndView(destino);
	}

}
