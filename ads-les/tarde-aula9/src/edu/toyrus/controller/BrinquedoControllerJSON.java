package edu.toyrus.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.toyrus.dao.BrinquedoDAO;
import edu.toyrus.dao.BrinquedoDAOImpl;
import edu.toyrus.dao.DAOException;
import edu.toyrus.entidade.Brinquedo;

@WebServlet("/brinquedoControllerJSON")
public class BrinquedoControllerJSON extends HttpServlet {
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) { 
		System.out.println("BrinquedoControllerJSON acionado");
		try {
			System.out.println("Conteudo recebido: ");
			BufferedReader reader = request.getReader();
			StringBuffer texto = new StringBuffer();
			while(reader.ready()) {
				texto.append(reader.readLine());
			}
			System.out.println(texto.toString());
			Gson gson = new Gson();
			Brinquedo b = gson.fromJson(texto.toString(), 
									Brinquedo.class);
			BrinquedoDAO daoBrinq = new BrinquedoDAOImpl();
			daoBrinq.adicionar(b);
			System.out.println("Gravado no banco de dados");
		} catch (IOException | DAOException e) {
			e.printStackTrace();
		}
		
	}

}
