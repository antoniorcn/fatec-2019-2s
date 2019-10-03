package edu.tartaruga.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.tartaruga.dao.DAOException;
import edu.tartaruga.dao.EntregaDAO;
import edu.tartaruga.dao.EntregaDAOImpl;
import edu.tartaruga.entidade.Entrega;

@WebServlet("/entregaController")
public class EntregaController extends HttpServlet {

	private List<Entrega> fazerPesquisa(HttpSession session, String origem) throws DAOException { 
		EntregaDAO entregaDAO = new EntregaDAOImpl();
		List<Entrega> entregas = entregaDAO.pesquisar(origem);
		session.setAttribute("LISTA", entregas);
		return entregas;
	}

	@Override
	public void doPost(HttpServletRequest request, 
			HttpServletResponse response) {

		String strId = request.getParameter("id");
		String strOrigem = request.getParameter("origem");
		String strDestino = request.getParameter("destino");
		String strStatus = request.getParameter("status");
		String cmd = request.getParameter("cmd");
		String mensagem = "Erro ao executar a ação";
		HttpSession session = request.getSession();
		EntregaDAO entregaDAO = new EntregaDAOImpl();
		try {
			if ("adicionar".equals(cmd)) { 
				Entrega e = new Entrega();
				e.setId(Long.parseLong(strId));
				e.setOrigem(strOrigem);
				e.setDestino(strDestino);
				e.setStatus(strStatus);
				entregaDAO.adicionar(e);
				fazerPesquisa(session, "");
				mensagem = "Entrega gravada com sucesso";
			} else if ("pesquisar".equals(cmd)) {
				List<Entrega> entregas = fazerPesquisa(session, strOrigem);
				mensagem = "Pesquisa executada com sucesso, foram encontradas " +
								entregas.size() + " entregas";
			} else if ("apagar".equals(cmd)) {
				long id = Long.parseLong(strId);
				entregaDAO.removerPorId(id);
				fazerPesquisa(session, "");
				mensagem = "Registro com Id " + id + "removido com sucesso";
			}
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		
		session.setAttribute("MENSAGEM", mensagem);

		try {
			response.sendRedirect("./entrega.jsp");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
