package br.com.nexti.pedido.models.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.nexti.pedido.models.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

	public Pedido findById(int id);
	
}
