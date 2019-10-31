package edu.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteCombos {
	private EntityManagerFactory emf;
	
	public TesteCombos() { 
		emf = Persistence.createEntityManagerFactory("PIZZARIA");
	}
	
	public void gerarPizzas() { 		
		Pizza p1 = new Pizza();
		p1.setSabor("Mussarela");
		p1.setTamanho("Grande");
		
		Pizza p2 = new Pizza();
		p2.setSabor("Calabresa");
		p2.setTamanho("Grande");
		
		Pizza p3 = new Pizza();
		p3.setSabor("Bacon");
		p3.setTamanho("Grande");
		
		Pizza p4 = new Pizza();
		p4.setSabor("Alho");
		p4.setTamanho("Grande");
		
		Bebida b1 = new Bebida();
		b1.setNome("Coca cola 2L");
		b1.setFabricante("Coca Cola Company");
		
		Bebida b2 = new Bebida();
		b2.setNome("Guarana Antarctica 2L");
		b2.setFabricante("Ambev");
		
		Bebida b3 = new Bebida();
		b3.setNome("Guarana Jesus 2L");
		b3.setFabricante("Coca Cola Company");
		
		Bebida b4 = new Bebida();
		b4.setNome("Suco de Laranja Del Valle 1L");
		b4.setFabricante("Coca Cola Company");
		
		Bebida b5 = new Bebida();
		b5.setNome("Agua Cristal 1.5L");
		b5.setFabricante("Coca Cola Company");
		
		Combo c1 = new Combo();
		c1.setNome("Cancer Certo");
		c1.getPizzas().add(p2);
		c1.getPizzas().add(p3);
		c1.getBebidas().add(b1);
		
		Combo c2 = new Combo();
		c2.setNome("Blade");
		c2.getPizzas().add(p4);
		c2.getBebidas().add(b3);
		
		EntityManager em = emf.createEntityManager();
		Object[] alimentos = new Object[] {c1, c2, p1, p2, p3, p4, b1, b2, 
												b3, b4, b5};
		em.getTransaction().begin();
		for (Object o : alimentos) { 
			em.persist(o);
		}
		em.getTransaction().commit();
		em.close();
	}
	
	public void exibirMenuCombos(String nome) { 
		EntityManager em = emf.createEntityManager();
		String hql = "select c from Combo c where nome like :nome";
		TypedQuery<Combo> qry = em.createQuery(hql, Combo.class);
		qry.setParameter("nome", "%" + nome + "%");
		List<Combo> combos = qry.getResultList();
		
		for (Combo c : combos) { 
			System.out.format("Combo (%d) - %s \n", c.getId(), c.getNome());
			for (Pizza p : c.getPizzas()) { 
				System.out.format("\tPizza (%d) - %s \n", p.getId(), p.getSabor());
			}
			for (Bebida b : c.getBebidas()) { 
				System.out.format("\tBebida (%d) - %s \n", b.getId(), b.getNome());
			}
		}
		em.close();
	}
	
	
	public static void main(String[] args) {
		TesteCombos tc = new TesteCombos();
		// tc.gerarPizzas();
		tc.exibirMenuCombos("Cancer");
	}

}
