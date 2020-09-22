package br.com.dh.lojaonline.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Database;
import models.Pedido;

@RestController
@RequestMapping(path = "pedido")
public class PedidoController {
	private Database db = new Database(); //banco de dados instanciado
	
	@GetMapping()
	public List<Object> getPedidos(){
		return db.list("pedidos");
	}
	
	@PostMapping()
	public void addCliente(Pedido pedido) {
		db.save("pedidos", pedido);
	}
}
