package edu.curso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AlunoTesteORM {

	public static void main(String[] args) {
			
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ALUNOS");
		EntityManager em = emf.createEntityManager();
		
		List<Aluno> alunos = pesquisar(em, "Antonio");
		for (Aluno a : alunos) { 
			System.out.format("Id: %d   Ra: %s   Nome: %s", 
					a.getId(), a.getRa(), a.getNome());
		}
		
		em.close();
		emf.close();
		
	}
	
	public static void adicionar(EntityManager em) { 
		Aluno a1 = new Aluno();
		a1.setId(0);
		a1.setNome("Antonio Rodrigues");
		a1.setEmail("antonio@hotmail.com");
		a1.setTelefone("1111-1111");
		a1.setSexo(true);
		a1.setPeso(88.0f);
		a1.setRa("11111");
		
		em.getTransaction().begin();
		em.persist( a1 );
		em.getTransaction().commit();
	}
	
	public static List<Aluno> pesquisar(EntityManager em, String n) { 
		TypedQuery<Aluno> qry = 
				em.createQuery("select a from Aluno a where nome like :nome", 
				Aluno.class);
		qry.setParameter("nome", "%" + n + "%");
		return qry.getResultList();
	}
}
