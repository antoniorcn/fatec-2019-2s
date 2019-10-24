package edu.curso.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.entidades.Entrega;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Long> {

}
