package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/MeuServlet")
public class MeuServlet implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {
	}
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	@Override
	public String getServletInfo() {
		return "Meu Servlet";
	}
	@Override
	public void init(ServletConfig s) throws ServletException {
		config = s;
		System.out.println("Servlet iniciado");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n = req.getParameter("NOMEALUNO");
		System.out.println("Parametro recebido NOMEALUNO=" + n);
		System.out.println("Servlet sendo executado");
		
		PrintWriter out = res.getWriter();
		out.write("<h1>Ola " + n + " como vai voce?</h1>");
		out.flush();		
	}
	
	
	
	
	
	
	
	
}
