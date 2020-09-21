package br.com.dh.lojaonline.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Cliente;
import models.Database;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
	private Database db = new Database(); //banco de dados instanciado
	
	@GetMapping()
	public List<Object> getClientes(){
		return db.list("clientes");
	}
	
	@PostMapping()
	public void addCliente(Cliente cliente) {
		db.save("clientes", cliente);
	}
	
}
