package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Tabuada")
public class Tabuada implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {	}
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	@Override
	public String getServletInfo() {
		return "Gerador de Tabuadas";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String strNum = req.getParameter("NUMERO");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int num = 7;
		try { 
			num = Integer.parseInt(strNum);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		for (int i = 0; i <= 10; i++) { 
			int r = num * i;
			String texto = String.format("%d X %d = %d", num, i, r);
			out.write("<h2>" + texto + "</h2>");
		}
		out.flush();
	}
	

}
