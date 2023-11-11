package edu.bootcamp.backoffice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bootcamp.backoffice.model.Cliente;
import edu.bootcamp.backoffice.repository.dao.ClienteDAO;
import edu.bootcamp.backoffice.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDAO dao;
	
	@Override
	public Cliente getById(Integer id) {
		return dao.getById(id);
	}

	@Override
	public List<Cliente> list() {
		return dao.list();
	}

	@Override
	public boolean add(Cliente entity) {
		if(dao.getById(entity.getId())==null) {
			dao.insert(entity);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean remove(Integer id) {
		if(dao.getById(id)!=null) {
			dao.delete(id);
			return true;
		}
		return false;
		
	}

	@Override
	public void modify(Cliente entity) {
		if(dao.getById(entity.getId())!=null) {
			dao.update(entity);
		}
	}

}
