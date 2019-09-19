package edu.tartaruga.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.tartaruga.dao.DAOException;
import edu.tartaruga.dao.EntregaDAO;
import edu.tartaruga.dao.EntregaDAOImpl;
import edu.tartaruga.entidade.Entrega;

@WebServlet("/entregaControllerJSON")
public class EntregaControllerJSON extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			BufferedReader reader = request.getReader();
			StringBuffer texto = new StringBuffer();
			while (reader.ready()) { 
				texto.append(reader.readLine());
			}
			
			System.out.println(texto.toString());
			
			Gson gson = new Gson();
			Entrega e = gson.fromJson(texto.toString(), Entrega.class);
					
			EntregaDAO entregaDAO = new EntregaDAOImpl();
		
			entregaDAO.adicionar(e);
			System.out.println("Entrega gravada com sucesso");
			response.getWriter().println("Ok funcionou");
			response.setStatus(200);
		} catch (DAOException e1) {
			System.out.println("Erro ao gravar a entrega");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
