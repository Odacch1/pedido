package br.com.nexti.pedido.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nexti.pedido.models.entities.Cliente;
import br.com.nexti.pedido.models.repositories.ClienteRepository;

@RestController
@RequestMapping(path = {"/cliente"})
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public Cliente getCliente(int id) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return null;
		}
		return cliente;
	}
	
	@GetMapping(path= {"/lista"})
	public Iterable<Cliente> getClientes() {
		
		return clienteRepository.findAllAtivos();
	}
	
	@PostMapping
	public Cliente cadastrarCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@PutMapping("/desativar")
	public String desativarCliente(int id) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return "Cliente não encontrado";
		}
		
		cliente.setAtivo(false);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNome() + " desativado!";
	}
	
	@PutMapping("/ativar")
	public String ativarCliente(int id) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return "Cliente não encontrado";
		}
		
		cliente.setAtivo(true);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNome() + " ativado!";
	}
	
	@PutMapping("/alterarNome")
	public String alterarNomeById(int id, String nome) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return "Cliente não encontrado";
		}
		
		cliente.setNome(nome);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNome() + " atualizado!";
	}
	
	@PutMapping("/alterarCpf")
	public String alterarCpfById(int id, String cpf) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return "Cliente não encontrado";
		}
		
		cliente.setCpf(cpf);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNome() + " atualizado!";
	}
	
	@PutMapping("/alterarNascimento")
	public String alterarDataNascimentoById(int id, Date dataNascimento) {
		Cliente cliente = new Cliente();
		try {
			cliente = clienteRepository.findById(id);
		} catch (Exception e) {
			return "Cliente não encontrado";
		}
		
		cliente.setDataNascimento(dataNascimento);
		clienteRepository.save(cliente);
		return "Cliente " + cliente.getNome() + " atualizado!";
	}
}
