package edu.toyrus.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.toyrus.dao.BrinquedoDAO;
import edu.toyrus.dao.BrinquedoDAOImpl;
import edu.toyrus.entidade.Brinquedo;

@WebServlet("/brinquedoController")
public class BrinquedoController extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, 
				HttpServletResponse response) { 
		System.out.println("Executado servlet BrinquedoController");
		
		try {
			String strId = request.getParameter("txtId");
			if (strId == null || strId == "") { 
				strId = "0";
			}
			long id = Long.parseLong(strId);
			String strNome = request.getParameter("txtNome");
			String strCategoria = request.getParameter("txtCategoria");
			
			Brinquedo b = new Brinquedo();
			b.setId(id);
			b.setNome(strNome);
			b.setCategoria(strCategoria);
			
			BrinquedoDAO daoBrinq = new BrinquedoDAOImpl();
			daoBrinq.adicionar(b);
			System.out.println("Gravado com sucesso");
		} catch (Exception e1) {
			System.out.println("Erro ao gravar o brinquedo");
			e1.printStackTrace();
		}
		
		
		try {
			response.sendRedirect("./brinquedo.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
