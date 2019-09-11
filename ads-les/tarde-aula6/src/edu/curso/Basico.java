package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.protocol.https.HttpsURLConnectionImpl;
@WebServlet("/Basico")
public class Basico extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, 
		HttpServletResponse res) 
		throws IOException { 
//			PrintWriter out = res.getWriter();
//			out.write("Servlet Basico respondendo");
//			out.flush();
	
		res.sendRedirect("./principal.html");
		res.setStatus(HttpServletResponse.SC_OK);
	}
}
