package edu.toyrus.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			String cmd = request.getParameter("cmd");
			String strId = request.getParameter("id");
			if (strId == null || strId == "") { 
				strId = "0";
			}
			long id = Long.parseLong(strId);
			String strNome = request.getParameter("nome");
			String strCategoria = request.getParameter("categoria");
			String strFabricante = request.getParameter("fabricante");
			BrinquedoDAO daoBrinq = new BrinquedoDAOImpl();
			if ("salvar".equals(cmd)) { 
				Brinquedo b = new Brinquedo();
				b.setId(id);
				b.setNome(strNome);
				b.setCategoria(strCategoria);
				b.setFabricante(strFabricante);
				daoBrinq.adicionar(b);
				System.out.println("Gravado com sucesso");
			} else if ("pesquisar".equals(cmd)) {
				List<Brinquedo> brinquedos = daoBrinq.pesquisar(strNome);
				HttpSession session = request.getSession();
				session.setAttribute("LISTA", brinquedos);
				System.out.println("Foram localizados " + 
						brinquedos.size() + " brinquedos");
			}
			
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
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String strId = request.getParameter("id");
			String strCmd = request.getParameter("cmd");
			if ("delete".equals(strCmd)) { 
				long id = Long.parseLong(strId);
				System.out.println("Removido Brinquedo com Id: " + id);
				BrinquedoDAO daoBrinq = new BrinquedoDAOImpl();
				daoBrinq.removerPorId(id);
				List<Brinquedo> brinquedos = daoBrinq.pesquisar("");
				HttpSession session = request.getSession();
				session.setAttribute("LISTA", brinquedos);
			}
			response.setStatus(200);
		} catch (Exception e1) {
			System.out.println("Erro ao apagar o brinquedo");
			e1.printStackTrace();
			response.setStatus(500);
		}
	}

}
