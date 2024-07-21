package br.ufsm.csi.pp.exercicio_av1;

import java.util.HashMap;
import java.util.Map;

public class ServicesFactory {

    private ServicesFactory() { }
    private static ServicesFactory INSTANCE;
    private final Map<String, Servico> services = new HashMap<>();

    public static ServicesFactory getInstance() {
        synchronized (ServicesFactory.class) {
            if (INSTANCE == null) {
                INSTANCE = new ServicesFactory();
            }
            return INSTANCE;
        }
    }

    public Servico getServico(String nomeServico) {
        Servico servico = services.get(nomeServico);
        synchronized (ServicesFactory.class) {
            if (servico == null) {
                try {
                    servico = (Servico) Class.forName(nomeServico).newInstance();
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException("Nao existe classe para o nome de servico indicado.");
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("Classe indicada nao implementa a interface Servico.");
                } catch (InstantiationException e) {
                    throw new IllegalArgumentException("Classe de servico indicada nao possui o construtor default.");
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException("Classe de servico indicada nao pode possuir o construtor default private.");
                }
                services.put(nomeServico, servico);
            }
        }
        return servico;
    }

    public static void main(String[] args) {
        ServicesFactory factory = ServicesFactory.getInstance();
        Servico servico = factory.getServico("br.ufsm.csi.pp.aula1.PassagemParametros");
        servico.executar();
    }

}
