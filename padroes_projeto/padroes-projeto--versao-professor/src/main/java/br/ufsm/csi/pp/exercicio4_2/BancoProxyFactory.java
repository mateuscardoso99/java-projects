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

    public BancoInterface createBancoInstance() {
        return (BancoInterface) Proxy.newProxyInstance(BancoInterface.class.getClassLoader(),
                new Class[] { BancoInterface.class },
                new BancoProxyInvocationHandler(new Banco())
        );
    }

    public class BancoProxyInvocationHandler implements InvocationHandler {

        private BancoInterface banco;
        private FileOutputStream arquivoLog;

        @SneakyThrows
        public BancoProxyInvocationHandler(BancoInterface banco) {
            this.banco = banco;
            this.arquivoLog = new FileOutputStream("log.txt");
        }

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
        banco.criaConta(Banco.TipoConta.RENDA_VARIAVEL, 100.0, false, null);
    }

}
