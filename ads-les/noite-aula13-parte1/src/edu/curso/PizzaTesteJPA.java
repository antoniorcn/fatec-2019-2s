package edu.curso;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PizzaTesteJPA {
	
	public static void main(String[] args) {
		Pizza p1 = new Pizza();
		p1.setId(0);
		p1.setSabor("Mussarela");
		p1.setPreco(10.0);
		p1.setTamanho("Grande");
		p1.setValidade(new Date());
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("PIZZARIA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}


}
