package com.algaworks.osworks.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.osworks.domain.model.Cliente;


//interface responsavel por manipular o banco de dados


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);//metodo para retornar um dado especifico
	List<Cliente> findByNomeContaining(String nome);//semelhante ao like do banco de dados
	Cliente findByEmail(String email);
}
