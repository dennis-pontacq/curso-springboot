package edu.bootcamp.backoffice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bootcamp.backoffice.model.Cliente;
import edu.bootcamp.backoffice.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService service;
	
	@GetMapping(value="clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> get() {
		return service.list();
	}
	
	@GetMapping(value="clientes/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente get(@PathVariable("id") int id) {
		return service.getById(id);
	}

	@PostMapping(value="clientes", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String post(@RequestBody Cliente entity) {
		return String.valueOf(service.add(entity));
	}

	@PutMapping(value="clientes", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void put(@RequestBody Cliente entity) {
		service.modify(entity);
	}

	@DeleteMapping(value="clientes/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") int id) {
		service.remove(id);
	}

}
