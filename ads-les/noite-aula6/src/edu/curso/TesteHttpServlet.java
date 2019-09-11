package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TesteHttpServlet")
public class TesteHttpServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		res.setStatus(200);
		PrintWriter out = res.getWriter();
		out.println("<html><h1>Ola teste Http Servlet</h1></html>");
		out.flush();
	}
}
