package br.ufsm.csi.pp.exercicio4_2;

import br.ufsm.csi.pp.exercicio2.Banco;
import br.ufsm.csi.pp.exercicio2.BancoInterface;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Proxy Dinâmico
 * 
 * 
 * – No Java é possível a criação de proxies dinâmicos através da API de Reflexão.
 * Porém, por padrão, é possível criar proxies apenas de interfaces:
 * 
 * A classe original precisa implementar uma interface, que por sua vez será implementada também pela classe Proxy.
 * 
 * Os proxies dinâmicos permitem que uma única classe com um único método atenda múltiplas chamadas de método para classes arbitrárias com um número arbitrário de métodos.
 * Um proxy dinâmico pode ser pensado como uma espécie de Façade , mas que pode fingir ser uma implementação de qualquer interface. Nos bastidores, ele roteia todas as invocações de métodos para um único manipulador – o método Invoke() .
 * 
 */






/*
 *  Implementar a mesma funcionalidade de Logs do Banco porém através de um Proxy dinâmico;
    a) Nos logs deverá haver o tempo decorrido na invocação de cada método;
    b) Alterar o método factory estático getInstancia(), para entregar um proxy do Banco.
 */
public class BancoProxyFactory {

    private static BancoProxyFactory INSTANCE;

    private BancoProxyFactory() { }

    public static BancoProxyFactory getInstance() {
        synchronized (BancoProxyFactory.class) {
            if (INSTANCE == null) {
                INSTANCE = new BancoProxyFactory();
            }
            return INSTANCE;
        }
    }

    //Uma instância de proxy atendida pelo manipulador de invocação que acabamos de definir é criada por meio de uma chamada de método de fábrica na classe java.lang.reflect.Proxy :
    //precisa passar uma interface, nesse exemplo BancoInterface.class
    //no caso foi passado a interface BancoInterface, mas poderia ser QUALQUER interface, incluindo List, Map etc.. 
    //daí ao chamar os métodos dessas interfaces o método invoke() vai ser chamado em vez de chamar o método da interface
    //exemplo: na linha 97 banco.extrato() é chamado mas NÃO será executado pela classe Banco, e sim pelo proxy APENAS, através do método invoke()
    public BancoInterface createBancoInstance() {
        return (BancoInterface) Proxy.newProxyInstance(
                                    BancoInterface.class.getClassLoader(),
                                    new Class[] { BancoInterface.class },
                                    new BancoProxyInvocationHandler(new Banco())
                                );
    }

    //para o proxy dinamico funcionar recisamos criar um subtipo de java.lang.reflect.InvocationHandler:
    public class BancoProxyInvocationHandler implements InvocationHandler {

        private BancoInterface banco;
        private FileOutputStream arquivoLog;

        @SneakyThrows
        public BancoProxyInvocationHandler(BancoInterface banco) {
            this.banco = banco;
            this.arquivoLog = new FileOutputStream("log.txt");
        }

        //o método invoke() vai ser executado SEMPRE que algum método da interface BancoInteface for chamado
        //só que pra chamar um método de BancoInterface precisa ter alguém que a implementa, por isso se usou a classe Banco
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long milis = System.currentTimeMillis();
            Object ret = method.invoke(banco, args);
            milis = System.currentTimeMillis() - milis;
            this.arquivoLog.write(("[" + new Date() + "]" + method.getName() + " (" + milis + "ms)> ").getBytes(StandardCharsets.UTF_8));
            for (int i = 0; i < args.length; i++) {
                this.arquivoLog.write((args[i] + ", ").getBytes(StandardCharsets.UTF_8));
            }
            this.arquivoLog.write("\n".getBytes(StandardCharsets.UTF_8));
            return ret;
        }
    }

    public static void main(String[] args) {
        BancoInterface banco = BancoProxyFactory.getInstance().createBancoInstance();
        banco.criaConta(Banco.TipoConta.RENDA_VARIAVEL, 100.0, false, null); //chamando método de BancoInterface, invoke() será chamado
        banco.extrato("2"); //chamando método de BancoInterface, invoke() será chamado
    }

}
