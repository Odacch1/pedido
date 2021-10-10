package br.com.nexti.pedido.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nexti.pedido.models.entities.Produto;
import br.com.nexti.pedido.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping
	public Produto getProduto(int id) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);	
		} catch (Exception e) {
			return null;
		}
		return produto;
	}
	
	@GetMapping(path = "/lista")
	public Iterable<Produto> getProdutos() {
		return produtoRepository.findAllAtivos();
	}
	
	@PostMapping
	public Produto cadastrarProduto(Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@PutMapping("/desativar")
	public String desativarProduto(int id) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setAtivo(false);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " desativado!";
	}
	
	@PutMapping("/ativar")
	public String ativarProduto(int id) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setAtivo(true);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " ativado!";
	}
	
	@PutMapping("/alterarNome")
	public String alterarNomeById(int id, String nome) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setNome(nome);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " alterado!";
	}
	
	@PutMapping("/alterarDescricao")
	public String alterarDescricaoById(int id, String descricao) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setDescricao(descricao);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " alterado!";
	}
	
	@PutMapping("/alterarPreco")
	public String alterarPrecoById(int id, BigDecimal preco) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setPreco(preco);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " alterado!";
	}
	
	@PutMapping("/alterarQuantidade")
	public String alterarQuantidadeById(int id, BigDecimal quantidade) {
		Produto produto = new Produto();
		try {
			produto = produtoRepository.findById(id);
		} catch (Exception e) {
			return "Produto não encontrado";
		}
		
		produto.setQuantidade(quantidade);
		produtoRepository.save(produto);
		return "Produto " + produto.getNome() + " alterado!";
	}
}
