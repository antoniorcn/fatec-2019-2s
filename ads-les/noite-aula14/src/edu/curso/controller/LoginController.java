package edu.curso.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.curso.entidade.Usuario;

@Controller
public class LoginController {
	
	@Resource(name = "sessionUser")
	Usuario u;
	
	@RequestMapping(value="/login")
	public String login() { 
		return "login";
	}

	@RequestMapping(value="/principal")
	public String principal() { 
		if ("ADMIN".equals(u.getProfile())) { 
			return "principal";
		} else { 
			return "login";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout() { 
		u.setUsername("");
		u.setPassword("");
		u.setProfile("");
		return "login";
	}
	
	@RequestMapping(value="/loginController", method = {RequestMethod.POST})
	public String loginController(
			@RequestParam("username") String user,
			@RequestParam("password") String pass,
			HttpSession session) {
		String page = "erro";
		if ("admin".equals(user) && "admin".equals(pass)) { 
			page = "principal";
			u.setUsername(user);
			u.setPassword(pass);
			u.setProfile("ADMIN");
		}
		return page;
	} 
	

}
