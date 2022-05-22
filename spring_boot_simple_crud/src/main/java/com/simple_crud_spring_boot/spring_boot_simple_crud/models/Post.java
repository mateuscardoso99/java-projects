package com.simple_crud_spring_boot.spring_boot_simple_crud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity //significa que a classe é uma entidade, então é feita associação com uma tabela no bd
@Table(name = "posts")//mapeia o nome da tabela

public class Post {
    @Id //indica que o atributo está relacionado a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //geração do id será controlada automaticamente
    private long id;

    @Column(name = "title")//mapeia o nome da coluna, tamanho e se é nula ou não
    @NotBlank(message = "title is required") //valor não pode estar em branco, caso estiver retorna a mensagem
    private String title;

    @Column(name = "description")
    @NotBlank(message = "description is required")
    private String description;

    @Column(name = "text")
    @NotBlank(message = "text is required")
    private String text;

    public Post() {}

    public Post(String title, String description, String text){
        this.title = title;
        this.description = description;
        this.text = text;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text = text;
    }
}
