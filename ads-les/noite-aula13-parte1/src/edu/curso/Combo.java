package edu.curso;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Combo {

	private long id;
	private String nome;
	private Set<Pizza> pizzas = new HashSet<>();
	private Set<Bebida> bebidas = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length = 30)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(Set<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
}
