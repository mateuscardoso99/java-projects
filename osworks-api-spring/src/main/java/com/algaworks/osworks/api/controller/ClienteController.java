package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import com.algaworks.osworks.domain.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes")

public class ClienteController {
	
/* pode-se usar outras ides como o netbeans, pra isso deve-se criar o projeto
 * spring no link: https://start.spring.io/ e depois clicar em generate e
 * será baixado um arquivo zip que pode ser importado em outras ides
 */
	
/* erro: perhaps you are running on a jre rather than a jdk: o spring não
 * está encontrando o jdk, ir em build path -> configure build path ->
 * clicar em editar a jre library -> alternate JREs -> installed JREs -> add
 * -> standard vm -> em jre home encontrar a pasta do jdk no sistema*/	
	
	
	@Autowired //importando interface clienterepository
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	@GetMapping()
	public List<Cliente> listar() {//na rota '/clientes' será chamado esse metodo
		return clienteRepository.findAll();
		//select * no banco, não precisa implementar o metodo na interface, o proprio
		//findAll() faz a busca, mas haverá ocasioes onde sera necessario implementar
	
		//return clienteRepository.findByNome("joao");//buscando dado especifico
		//return clienteRepository.findByNomeContaining("j");
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		if(cliente.isPresent()) {//se existir retorna o cliente
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();//se estiver vazio retorna 404
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(/*@Valid*/ @RequestBody Cliente cliente) {//@Valid para ativar a validação
		return cadastroCliente.salvar(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = cadastroCliente.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cadastroCliente.excluir(id);
		return ResponseEntity.noContent().build();//retornando codigo 204
	}
}
