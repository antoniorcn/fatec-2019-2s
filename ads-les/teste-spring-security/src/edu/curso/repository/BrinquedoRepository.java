package edu.curso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.entidade.Brinquedo;

@Repository
public interface BrinquedoRepository 
	extends CrudRepository<Brinquedo, Long>{
	
	List<Brinquedo> findByNome(String nome);
}
