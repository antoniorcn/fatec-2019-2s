package edu.curso;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AlunoTesteORM {
	private EntityManagerFactory emf;
	
	public void generateEntityManagerFactory() { 
		emf = Persistence.createEntityManagerFactory("ALUNOS");
	}
	
	public EntityManager generateEntityManager() { 
		return emf.createEntityManager();
	}
	
	public void fecharEntityManagerFactor() { 
		emf.close();
	}
	
	public void executar() { 
		EntityManager em = generateEntityManager();
		List<Aluno> alunos = pesquisar(em, "Antonio");
		for (Aluno a : alunos) { 
			System.out.format("Id: %d   Ra: %s   Nome: %s", 
					a.getId(), a.getRa(), a.getNome());
		}
		em.close();
	}
	
	public static void main(String[] args) {	
		AlunoTesteORM orm = new AlunoTesteORM();
		orm.generateEntityManagerFactory();
//		orm.adicionarSalas();
//		orm.adicionarAlunos();
		EntityManager em = orm.generateEntityManager();
		
		TypedQuery<Aluno> qryAluno = 
				em.createQuery("select a from Aluno a", Aluno.class);
		List<Aluno> alunos = qryAluno.getResultList();
		
		TypedQuery<Sala> qrySala = 
				em.createQuery("select s from Sala s", Sala.class);
		List<Sala> salas = qrySala.getResultList();
		
		em.getTransaction().begin();
		salas.get(0).getAlunos().add(alunos.get(0));
		salas.get(0).getAlunos().add(alunos.get(1));
		salas.get(1).getAlunos().add(alunos.get(1));
		salas.get(1).getAlunos().add(alunos.get(2));
		em.getTransaction().commit();
		em.close();
		orm.fecharEntityManagerFactor();
	}
	
	public List<Sala> adicionarSalas() { 
		Sala s1 = new Sala();
		s1.setId(1l);
		s1.setNome("201");
		s1.setDisciplina("Laboratorio Eng. Sofware");
		
		Sala s2 = new Sala();
		s2.setId(2l);
		s2.setNome("102");
		s2.setDisciplina("Banco de Dados");
		
		EntityManager em = generateEntityManager();
		em.getTransaction().begin();
		em.persist( s1 );
		em.persist( s2 );
		em.getTransaction().commit();
		em.close();
		
		List<Sala> salas = new ArrayList<>();
		salas.add(s1);
		salas.add(s2);
		return salas;
	}
	
	public List<Aluno> adicionarAlunos() { 
		Aluno a1 = new Aluno();
		a1.setId(1l);
		a1.setNome("Joao Silva");
		a1.setEmail("joaosilva@hotmail.com");
		a1.setTelefone("1111-1111");
		a1.setSexo(true);
		a1.setPeso(88.0f);
		a1.setRa("11111");
		
		Aluno a2 = new Aluno();
		a2.setId(2l);
		a2.setNome("Maria do Rosario");
		a2.setEmail("mariarosario@hotmail.com");
		a2.setTelefone("2222-2222");
		a2.setSexo(true);
		a2.setPeso(68.0f);
		a2.setRa("22222");
		
		Aluno a3 = new Aluno();
		a3.setId(3l);
		a3.setNome("Pedro Pacheco");
		a3.setEmail("pedropacheco@hotmail.com");
		a3.setTelefone("3333-3333");
		a3.setSexo(true);
		a3.setPeso(75.0f);
		a3.setRa("33333");
		
		EntityManager em = generateEntityManager();
		em.getTransaction().begin();
		em.persist( a1 );
		em.persist( a2 );
		em.persist( a3 );
		em.getTransaction().commit();
		em.close();
		
		List<Aluno> alunos = new ArrayList<>();
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		return alunos;
	}
	
	public static List<Aluno> pesquisar(EntityManager em, String n) { 
		TypedQuery<Aluno> qry = 
				em.createQuery("select a from Aluno a where nome like :nome", 
				Aluno.class);
		qry.setParameter("nome", "%" + n + "%");
		return qry.getResultList();
	}
}
