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
	private ServletConfig cfg;
	@Override
	public void destroy() {	}
	@Override
	public ServletConfig getServletConfig() {
		return cfg;
	}
	@Override
	public String getServletInfo() {
		return "Este é o MeuServlet";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.cfg = config;		
		System.out.println("Init está sendo executado");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n = req.getParameter("NOME");
		String i = req.getParameter("IDADE");
		System.out.println("Service está sendo executado");
		PrintWriter out = res.getWriter();
		out.println("<h1>Ola " + n + " bem vindo ao MeuServlet</h1>");
		out.flush();
	}

}
