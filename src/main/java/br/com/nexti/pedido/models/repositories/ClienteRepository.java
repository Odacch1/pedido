package br.com.nexti.pedido.models.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.com.nexti.pedido.models.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>{
	
	@Query("SELECT c FROM Cliente c WHERE c.ativo is true")
	public Iterable<Cliente> findAllAtivos();
	
	public Cliente findById(int id);
}
