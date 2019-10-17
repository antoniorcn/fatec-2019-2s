package edu.curso.entidades;

import java.util.Date;

public class QuartoHotel {
	private long id;
	private String numeroQuarto;
	private Date dataReserva;
	private double valorDiaria;
	private int numeroCamas;
	private String observacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public Date getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
	public int getNumeroCamas() {
		return numeroCamas;
	}
	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
