package br.com.dh.lojaonline.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Pedido;
import br.com.dh.lojaonline.model.repositories.PedidoRepository;

@RestController
@RequestMapping(path = "pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping()
	public Iterable<Pedido> getPedido(){
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/{idPedido}")
	public Optional<Pedido> getById(@PathVariable int idPedido){
		return pedidoRepository.findById(idPedido);
	}
	
	@PostMapping()
	public Pedido addPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido;
	}
	
	@PutMapping("/{idPedido}")
	public Pedido updatePedido(@PathVariable int idPedido, @RequestBody Pedido dadosPedido) throws Exception {
		Pedido meuPedido = pedidoRepository.findById(idPedido)
				.orElseThrow(( () -> new IllegalAccessException()));
		
		if(!dadosPedido.getNfe().isEmpty()) meuPedido.setNfe(dadosPedido.getNfe());
		if(!dadosPedido.getStatus_pedido().isEmpty()) meuPedido.setStatus_pedido(dadosPedido.getStatus_pedido());
		
		
		pedidoRepository.save(meuPedido);
		
		return meuPedido;
	}
	
	@DeleteMapping("/{idPedido}")
	public void deletePedido(@PathVariable int idPedido) {
		pedidoRepository.deleteById(idPedido);
	}
	
}
