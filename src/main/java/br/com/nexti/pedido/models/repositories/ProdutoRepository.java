package br.com.nexti.pedido.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.nexti.pedido.models.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
	public Produto findById(int id);
	
	@Query("SELECT p FROM Produto p WHERE p.ativo is true")
	public Iterable<Produto> findAllAtivos();
}
