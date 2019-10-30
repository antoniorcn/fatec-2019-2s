package edu.curso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login() { 
		System.out.println("Login invocado");
		return "login";
	}
	
	@RequestMapping("/principal")
	public String principal() { 
		System.out.println("Principal invocado");
		return "principal";
	}
	
	@RequestMapping("/loginController")
	public ModelAndView loginController(
			@RequestParam(value = "error", required = false) String error, 
            @RequestParam(value = "logout", required = false) String logout,
            ModelAndView mv) { 
		System.out.println("Login Controller invocado");
		String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if(logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        mv.addObject("message", errorMessge);
		return mv;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Logout invocado");
        return "login";
    }
	
	@RequestMapping("/error")
	public String login(@RequestParam(value = "error", required = false) String error) { 
		System.out.println("Error invocado");
		System.out.println(error);
		return "error";
	}

}
