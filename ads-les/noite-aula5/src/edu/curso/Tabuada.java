package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/tabuada")
public class Tabuada implements Servlet {
	private ServletConfig cfg;
	@Override
	public void destroy() {}
	@Override
	public ServletConfig getServletConfig() {return cfg;}
	@Override
	public String getServletInfo() {
		return "Servlet de Tabuada";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		cfg = config;
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Executando codigo da Tabuada");
		res.setContentType("text/html");
		String strNum = req.getParameter("NUMERO");
		PrintWriter out = res.getWriter();
		
		int num = 7;
		try { 
			num = Integer.parseInt(strNum);
		} catch(Exception e) { 
			e.printStackTrace();
		}
		
		for (int i = 0; i <= 10; i++) { 
			int r = i * num;
			String txt = String.format("<h2>%d  X  %d  =  %d</h2>", num, i, r);
			out.write(txt);
		}
		out.flush();
	}


}
