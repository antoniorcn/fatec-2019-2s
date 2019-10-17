package edu.curso.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Entrega {
	private long id;
	private String origem = "";
	private String destino = "";
	private String dimensoes = "";
	private float peso;
	private Date data = new Date();
	private float frete;
	private String status;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getDimensoes() {
		return dimensoes;
	}
	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public float getFrete() {
		return frete;
	}
	public void setFrete(float frete) {
		this.frete = frete;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Entrega) { 
			Entrega e = (Entrega)o;
			return e.getId() == this.getId();
		}
		return false;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
		sb.append("Id" + getId());
		sb.append("Origem" + getOrigem());
		sb.append("Destino" + getDestino());
		sb.append("Data" + sdf.format(getData()));
		sb.append("Status" + getStatus());
		return sb.toString();
	}
}
