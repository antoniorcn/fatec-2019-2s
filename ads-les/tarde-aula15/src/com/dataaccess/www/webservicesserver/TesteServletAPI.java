package com.dataaccess.www.webservicesserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

class Pet { 
	private String raca;
	private double peso;
	private String nome;
	private String nomeDono;
	private Date nascimento;
	
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeDono() {
		return nomeDono;
	}
	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
}

@WebServlet("/pets")
public class TesteServletAPI extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		Pet p1 = new Pet();
		p1.setNome("Lulu");
		p1.setPeso(22.5);
		p1.setRaca("Sao Bernardo");
		p1.setNascimento(new Date());
		
		Pet p2 = new Pet();
		p2.setNome("Rex");
		p2.setPeso(19.5);
		p2.setRaca("Pastor Alemao");
		p2.setNascimento(new Date());
		
		PrintWriter out = res.getWriter();
		
		Pet[] pets = {p1, p2};
		
		Gson gson = new Gson();
		out.print(gson.toJson(pets));
		out.flush();
		
	}
}
