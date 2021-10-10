package br.com.nexti.pedido.models.entities;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="clienteId")
	private Cliente cliente;
	
	private BigDecimal totalCompra;
	
	private Date dataCompra;
	
	@NotNull
	@Access(AccessType.PROPERTY)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Produto> produtos;

	public Pedido() {
		super();
		this.totalCompra = BigDecimal.ZERO;
		this.dataCompra = new Date();
	}

	public int getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void calcularValorTotal() {
		this.totalCompra = BigDecimal.ZERO;
		for(Produto produto : produtos)
			this.totalCompra = this.totalCompra.add(produto.getPreco().multiply(produto.getQuantidade()));
	}
	
	public boolean adicionaProduto(Produto produto) {
		if(produto.getQuantidade().compareTo(BigDecimal.ZERO) > 0) {
			this.produtos.add(produto);
			this.calcularValorTotal();
			return true;
		}
		return false;
	}
	
	public boolean removeProduto(Produto produto) {
		for(Produto produtoTemp : produtos) {
			if(produtoTemp.equals(produto)) {
				produtos.remove(produtoTemp);
				return true;
			}
		}
		return false;
	}
}
