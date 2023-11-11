package edu.bootcamp.backoffice.service;

import java.util.List;

import edu.bootcamp.backoffice.model.Cliente;

public interface ClienteService {
	
	public Cliente getById(Integer id);
	
	public List<Cliente> list();
	
	public boolean add(Cliente entity);

	public boolean remove(Integer id);
	
	public void modify(Cliente entity); 
}
