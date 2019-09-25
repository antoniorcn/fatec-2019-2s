package edu.tartaruga.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.tartaruga.dao.DAOException;
import edu.tartaruga.dao.EntregaDAO;
import edu.tartaruga.dao.EntregaDAOImpl;
import edu.tartaruga.entidade.Entrega;

@WebServlet("/entregaController")
public class EntregaController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) {
		
		String strId = request.getParameter("id");
		String strOrigem = request.getParameter("origem");
		String strDestino = request.getParameter("destino");
		String strStatus = request.getParameter("status");
		
		Entrega e = new Entrega();
		e.setId(Long.parseLong(strId));
		e.setOrigem(strOrigem);
		e.setDestino(strDestino);
		e.setStatus(strStatus);
		
		EntregaDAO entregaDAO = new EntregaDAOImpl();
		try {
			entregaDAO.adicionar(e);
			System.out.println("Entrega gravada com sucesso");
		} catch (DAOException e1) {
			System.out.println("Erro ao gravar a entrega");
			e1.printStackTrace();
		}
		
		
		try {
			response.sendRedirect("./entrega.jsp");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
