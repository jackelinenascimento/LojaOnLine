package br.com.dh.lojaonline.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Database;
import models.Produto;

@RestController
@RequestMapping(path = "produto")
public class ProdutoController {
	private Database db = new Database(); //banco de dados instanciado
	
	@GetMapping()
	public List<Object> getClientes(){
		return db.list("produtos");
	}
	
	@PostMapping()
	public void addCliente(Produto produto) {
		db.save("produtos", produto);
	}
	
}
