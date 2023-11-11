package edu.bootcamp.backoffice.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bootcamp.backoffice.model.Cliente;
import edu.bootcamp.backoffice.repository.dao.ClienteDAO;
import edu.bootcamp.backoffice.repository.jpa.ClienteJPA;

@Repository
public class ClienteRepositoryImpl  implements ClienteDAO {

	@Autowired
	private ClienteJPA repo;
	
	@Override
	public Cliente getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public List<Cliente> list() {
		return repo.findAll();
	}

	@Override
	public void insert(Cliente entity) {
		repo.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public void update(Cliente entity) {
		repo.save(entity);
	}
}