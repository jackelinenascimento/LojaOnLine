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

import br.com.dh.lojaonline.model.entities.Produto;
import br.com.dh.lojaonline.model.repositories.ProdutoRepository;

@RestController
@RequestMapping(path = "produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping()
	public Iterable<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{idProduto}")
	public Optional<Produto> getById(@PathVariable int idProduto){
		return produtoRepository.findById(idProduto);
	}
	
	@PostMapping()
	public Produto addProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@PutMapping("/{idProduto}")
	public Produto updateProduto(@PathVariable int idProduto, @RequestBody Produto dadosProduto) throws Exception {
		Produto meuProduto = produtoRepository.findById(idProduto)
				.orElseThrow(( () -> new IllegalAccessException()));
		
		if(!dadosProduto.getNome().isEmpty()) meuProduto.setNome(dadosProduto.getNome());
		if(dadosProduto.getPreco() != 0) meuProduto.setPreco(dadosProduto.getPreco());
		if(!dadosProduto.getDescricao().isEmpty()) meuProduto.setDescricao(dadosProduto.getDescricao());
		if(dadosProduto.getEstoque() != 0) meuProduto.setEstoque(dadosProduto.getEstoque());
		
		produtoRepository.save(meuProduto);
		
		return meuProduto;
	}
	
	@DeleteMapping("/{idProduto}")
	public void deleteProduto(@PathVariable int idProduto) {
		produtoRepository.deleteById(idProduto);
	}
}
