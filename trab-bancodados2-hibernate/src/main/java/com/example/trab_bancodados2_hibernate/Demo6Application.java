package com.example.trab_bancodados2_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class Demo6Application {
    public static void main(String[] args) throws IOException{

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String valorDigitado = null;

        Session session = sessionFactory.openSession();

        do {
            System.out.println("\n\n1-cadastrar restaurante");
            System.out.println("2-cadastrar cardápio");
            System.out.println("3-cadastrar refeição");
            System.out.println("4-adicionar refeição a um restaurante");
            System.out.println("5-listar restaurantes");
            System.out.println("6-buscar restaurante que possui refeições e cardápios");
            System.out.println("7-buscar restaurante");
            System.out.println("0-sair");

            valorDigitado = bufferedReader.readLine();

            switch (valorDigitado) {
                case "1" -> {
                    System.out.print("nome restaurante: ");
                    String nomeRestaurante = bufferedReader.readLine();

                    Query<Restaurante> query = session.createQuery(
                        "SELECT r FROM Restaurante r WHERE r.nome = :nome",
                        Restaurante.class
                    );
                    query.setParameter("nome", nomeRestaurante);
                    Restaurante restaurante = query.uniqueResult();
                    
                    if(restaurante != null){
                        System.out.println("restaurante já cadastrado");
                        continue;
                    }

                    Restaurante novoRestaurante = new Restaurante();
                    novoRestaurante.setNome(nomeRestaurante);
                    session.beginTransaction();
                    session.persist(novoRestaurante);
                    session.getTransaction().commit();
                    break;
                }
                case "2" -> {
                    System.out.print("descricao cardápio: ");
                    String nomeCardapio = bufferedReader.readLine();
                    System.out.print("Restaurante: ");
                    String nomeRestaurante = bufferedReader.readLine();

                    Query<Restaurante> query = session.createQuery(
                        "SELECT r FROM Restaurante r WHERE r.nome = :nome",
                        Restaurante.class
                    );
                    query.setParameter("nome", nomeRestaurante);
                    Restaurante restaurante = query.uniqueResult();
                    
                    if(restaurante == null){
                        System.out.println("restaurante não encontrado");
                        continue;
                    }

                    Cardapio c = new Cardapio();
                    c.setDescricao(nomeCardapio);
                    c.setRestaurante(restaurante);
                    restaurante.getCardapios().add(c);
                    session.beginTransaction();
                    session.persist(c);
                    session.persist(restaurante);
                    session.getTransaction().commit();
                    break;
                }
                case "3" -> {
                    System.out.print("cadastrar refeição: ");
                    valorDigitado = bufferedReader.readLine();
                    Refeicao ref = new Refeicao();
                    ref.setDescricao(valorDigitado);
                    session.beginTransaction();
                    session.persist(ref);
                    session.getTransaction().commit();
                    break;
                }
                case "4" -> {
                    System.out.print("refeição: ");
                    String nomeRefeicao = bufferedReader.readLine();

                    Query<Refeicao> query = session.createQuery(
                        "SELECT r FROM Refeicao r WHERE r.descricao = :descricao",
                        Refeicao.class
                    );
                    query.setParameter("descricao", nomeRefeicao);
                    Refeicao refeicao = query.uniqueResult();

                    if(refeicao == null){
                        System.out.println("refeição não encontrada");
                        continue;
                    }

                    System.out.print("Restaurante: ");
                    String nomeRestaurante = bufferedReader.readLine();
                    Query<Restaurante> query2 = session.createQuery(
                        "SELECT r FROM Restaurante r WHERE r.nome = :nome",
                        Restaurante.class
                    );
                    query2.setParameter("nome", nomeRestaurante);
                    Restaurante restaurante = query2.uniqueResult();
                    
                    if(restaurante == null){
                        System.out.println("restaurante não encontrado");
                        continue;
                    }

                    RestauranteRefeicao restauranteRefeicao = new RestauranteRefeicao();
                    restauranteRefeicao.setRefeicao(refeicao);
                    restauranteRefeicao.setRestaurante(restaurante);

                    restaurante.getRefeicoes().add(restauranteRefeicao);
                    
                    session.beginTransaction();
                    session.persist(restauranteRefeicao);
                    session.persist(restaurante);
                    session.getTransaction().commit();
                    break;
                }

                case "5" -> {
                    Query<Restaurante> query = session.createQuery(
                        "SELECT r FROM Restaurante r LEFT JOIN FETCH r.cardapios LEFT JOIN FETCH r.refeicoes rr LEFT JOIN FETCH rr.refeicao",
                        Restaurante.class
                    );
                    List<Restaurante> restaurantes = query.list();
                    restaurantes.forEach(r -> System.out.println(r.toString()));
                    break;
                }

                case "6" -> {
                    System.out.print("Restaurante: ");
                    String nomeRestaurante = bufferedReader.readLine();

                    Query<Restaurante> query = session.createQuery(
                        "SELECT r FROM Restaurante r JOIN FETCH r.cardapios JOIN FETCH r.refeicoes rr JOIN FETCH rr.refeicao WHERE r.nome = :nome",
                        Restaurante.class
                    );
                    query.setParameter("nome", nomeRestaurante);
                    Restaurante restaurante = query.uniqueResult();
                    
                    if(restaurante == null){
                        System.out.println("restaurante não encontrado");
                    }
                    else{
                        System.out.println(restaurante.toString());
                    }
                    break;
                }

                case "7" -> {
                    System.out.print("Restaurante: ");
                    String nomeRestaurante = bufferedReader.readLine();
                    Query<Restaurante> query = session.createQuery(
                        "SELECT r FROM Restaurante r WHERE r.nome = :nome",
                        Restaurante.class
                    );
                    query.setParameter("nome", nomeRestaurante);
                    Restaurante restaurante = query.uniqueResult();
                    if(restaurante == null){
                        System.out.println("restaurante não encontrado");
                    }
                    else{
                        System.out.println(restaurante.toString());
                    }
                    break;
                }
                default -> {
                    break;
                }
            }
            
        } while (!"0".equals(valorDigitado));

        session.close();
    }
}
