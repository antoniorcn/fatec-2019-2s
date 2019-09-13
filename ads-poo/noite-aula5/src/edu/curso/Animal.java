package edu.curso;

public class Animal {
	
	private float peso;
	private String especie;
	public Animal() { 
		
	}
	
	public Animal(String especie) {
		super();
		this.especie = especie;
		System.out.println("Construindo um Animal");
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
}
