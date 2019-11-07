package edu.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() { 
		return "login";
	}
	
	@RequestMapping("/principal")
	public String principal() { 
		return "principal";
	}
	
	@RequestMapping("/administrador")
	public String administrador() { 
		return "administrador";
	}
	
	@RequestMapping("/erro")
	public String erro() { 
		return "erro";
	}
	
	@RequestMapping("/403")
	public String erro403() { 
		return "erro";
	}

}
