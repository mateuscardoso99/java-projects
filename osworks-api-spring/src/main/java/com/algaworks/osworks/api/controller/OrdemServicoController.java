package com.algaworks.osworks.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.api.model.OrdemServicoEntrada;
import com.algaworks.osworks.api.model.OrdemServicoModel;
import com.algaworks.osworks.domain.model.OrdemServico;
import com.algaworks.osworks.domain.repository.OrdemServicoRepository;
import com.algaworks.osworks.domain.service.GestaoOrdemServicoService;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;//dependencia para mapeamento de entidades e objetos
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServicoModel criar(/*@Valid*/ @RequestBody OrdemServicoEntrada ordemServicoEntrada) {
		OrdemServico ordemServico = toEntity(ordemServicoEntrada);
		return toModel(gestaoOrdemServico.criar(ordemServico));
	}
	
	@GetMapping
	public List<OrdemServicoModel> listar(){
		return toCollectionModel(ordemServicoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoModel> buscar(@PathVariable Long id){
		Optional<OrdemServico> ordem = ordemServicoRepository.findById(id);
		
		if(ordem.isPresent()) {
			OrdemServicoModel modelo = toModel(ordem.get());
			return ResponseEntity.ok(modelo);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		gestaoOrdemServico.finalizar(id);
	}
	
	private OrdemServicoModel toModel(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoModel.class);
	}
	
	private List<OrdemServicoModel> toCollectionModel(List<OrdemServico> ordensServico){
		return ordensServico.stream()
				.map(ordemServico -> toModel(ordemServico))
				.collect(Collectors.toList());
	}
	
	private OrdemServico toEntity(OrdemServicoEntrada ordemServicoEntrada) {
		return modelMapper.map(ordemServicoEntrada, OrdemServico.class);
	}
	
}
