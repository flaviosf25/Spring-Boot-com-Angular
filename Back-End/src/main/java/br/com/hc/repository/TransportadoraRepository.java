package br.com.hc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hc.model.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer> {

	Transportadora findById(int id);	
	
}
