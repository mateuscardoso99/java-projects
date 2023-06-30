package br.csi.servlet_spring_aula.service;

import br.csi.servlet_spring_aula.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LivroService {

    public static ArrayList<Livro> livros = new ArrayList<>();

    public LivroService(){
        livros.add(new Livro("XD321","JAVA","Alencar"));
        livros.add(new Livro("654","PHP","Alencar"));
        livros.add(new Livro("34","DOT","Alencar"));
        livros.add(new Livro("789","Angular","Alencar"));
    }

    public ArrayList<Livro> getLivros(){

        return livros;
    }

    public Livro save(Livro livro){
        livros.add(livro);
        return livro;
    }

}
