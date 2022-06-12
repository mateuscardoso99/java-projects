package com.alura.forumspringapi.repository;

import com.alura.forumspringapi.modelo.Topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long>{//1o parametro: qual entidade, 2o qual o tipo da chave primária
    Page<Topico> findByCursoNome(String nome, Pageable paginacao);
    
    //filtrando pelo nome do atributo da entidade de um relacionamento, findBy[nome_entity][atributo]
    //se na entidade Topico tiver um atributo cursoNome, daria conflito pois teria nomes iguais,
    //a solução é no método que busca o atributo no relacionamento colocar "_" findByCurso_Nome,
    //é possível navegar em mais de 1 nivel de ralacionamentos ex: findByCursoCategoriaNome,
    //é possível escolher o nome que quiser mas daí o JPA não vai funcionar a solução é
    //usar a anotação @Query e escrever a consulta na mão e lincar o parametro tambem ex:

    //@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    //List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
