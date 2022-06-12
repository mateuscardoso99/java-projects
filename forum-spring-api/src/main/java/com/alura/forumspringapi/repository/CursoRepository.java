package com.alura.forumspringapi.repository;

import com.alura.forumspringapi.modelo.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long>{//1o parametro: qual entidade, 2o qual o tipo da chave primária
    Curso findByNome(String nome);
}