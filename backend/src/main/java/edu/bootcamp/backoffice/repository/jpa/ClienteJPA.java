package edu.bootcamp.backoffice.repository.jpa;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.bootcamp.backoffice.model.Cliente;

public interface ClienteJPA extends JpaRepository<Cliente, Integer> {

	Cliente findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("Delete from Cliente c Where c.email = ?1")
	void removeByEmail(String email);
	
}
