package com.example;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        DAOGenericoInterface<Log> logDao = new DAOGenerico<Log>(Log.class);
        //cria um DAOGenerico de Log, mas o tipo sempre deve ser a interface pois isso é uma boa prática

        DAOGenericoDecorator<Log> daoGenericoDecoratorLog = new DAOGenericoDecorator<>(logDao);
        //DAOGenericoDecorator será de uma entidade (Compra,Log,Cliente...) e recebe por parametro um dao qualquer que nesse caso é uma dao de Log.class

        daoGenericoDecoratorLog.create(new Log());
        daoGenericoDecoratorLog.getById(3);

        DAOGenericoInterface<Compra> compraDao = new DAOGenerico<Compra>(Compra.class);
        DAOGenericoDecorator<Compra> daoGenericoDecoratorCompra = new DAOGenericoDecorator<>(compraDao);
        daoGenericoDecoratorCompra.create(new Compra());
        daoGenericoDecoratorCompra.update(new Compra());

        //poderia fazer tudo isso usando herança em vez da interface DAOGenericoInterface
        //nesse caso cria-se uma classe abstrata com os métodos create, update, remove ...
        //e faz o DAOGenerico e DAOGenericoDecorator herdarem dela
    }
}
