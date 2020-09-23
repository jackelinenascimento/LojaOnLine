package br.com.dh.lojaonline.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.lojaonline.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
