package edu.bootcamp.backoffice.repository.dao;

import java.util.List;

import edu.bootcamp.backoffice.model.Cliente;

public interface ClienteDAO {

	public Cliente getById(int id);
	
	public List<Cliente> list();

	public void insert(Cliente entity);

	public void delete(Integer id);
	
	public void update(Cliente entity);
	
}
