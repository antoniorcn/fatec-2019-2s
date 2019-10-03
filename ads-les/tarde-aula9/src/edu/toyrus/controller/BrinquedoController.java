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
		String msg = null;
		HttpSession session = request.getSession();
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
				msg = "Brinquedo gravado com sucesso";
				System.out.println(msg);				
			} else if ("pesquisar".equals(cmd)) {
				List<Brinquedo> brinquedos = daoBrinq.pesquisar(strNome);
				session.setAttribute("LISTA", brinquedos);
				msg = "Foram localizados " + 
						brinquedos.size() + " brinquedos";
				System.out.println(msg);				
			}
			
		} catch (Exception e1) {
			msg = "Erro ao gravar o brinquedo";
			System.out.println(msg);
			e1.printStackTrace();
		}
		
		session.setAttribute("MENSAGEM", msg);
		
		try {
			response.sendRedirect("./brinquedo.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String msg = null;
		String strId = request.getParameter("id");
		String strCmd = request.getParameter("cmd");
		long id = Long.parseLong(strId);
		HttpSession session = request.getSession();
		try {
			if ("delete".equals(strCmd)) { 
				System.out.println("Removido Brinquedo com Id: " + id);
				BrinquedoDAO daoBrinq = new BrinquedoDAOImpl();
				daoBrinq.removerPorId(id);
				List<Brinquedo> brinquedos = daoBrinq.pesquisar("");
				session.setAttribute("LISTA", brinquedos);
				msg = String.format("Brinquedo com Id (%d) foi removido com sucesso",
						id);
			}
			response.setStatus(200);
		} catch (Exception e1) {
			System.out.println("Erro ao apagar o brinquedo");
			e1.printStackTrace();
			msg = String.format("Erro ao remover o brinquedo com Id (%d)",
					id);
			response.setStatus(500);
		}
		session.setAttribute("MENSAGEM", msg);
	}

}
