package com.example;

/*

Uma empresa de software deseja implementar um sistema de processamento
de pedidos de reembolso. O sistema deve ser capaz de passar um pedido de
reembolso por uma cadeia de diferentes níveis de autorização. Cada nível de
autorização tem um limite máximo de valor que pode aprovar. Se o valor do
reembolso exceder o limite de um nível de autorização, o pedido deve ser
encaminhado para o próximo nível na cadeia. 

– Níveis de Autorização: 
• Suporte Técnico: pode aprovar reembolsos de até R$ 100,00. 
• Gerente de Suporte: pode aprovar reembolsos de até R$ 1.000,00. 
• Diretor de Operações: pode aprovar reembolsos de até R$ 10.000,00. 
• CEO: pode aprovar qualquer valor de reembolso. 

– Classes a serem Implementadas: 
• Reembolso: Classe que representa um pedido de reembolso. Deve ter atributos como valor do reembolso e descrição. 
• Autorizador: Classe abstrata que define a estrutura para um autorizador na cadeia de responsabilidade. 
• SuporteTecnico, GerenteSuporte, DiretorOperacoes e CEO: Classes concretas que estendem Autorizador e implementam o comportamento de autorização específico. 

– Implementar testes: 
• Criar instâncias da cadeia de responsabilidade e enviando pedidos de reembolso com diferentes valores para verificar se cada pedido é aprovado corretamente pelo nível adequado.

*/

public class Main {
    public static void main(String[] args) {
        CEO ceo = new CEO();
        DiretorOperacoes diretorOperacoes = new DiretorOperacoes();
        GerenteSuporte gerenteSuporte = new GerenteSuporte();
        SuporteTecnico suporteTecnico = new SuporteTecnico();

        suporteTecnico.setProximoCadeia(gerenteSuporte);
        gerenteSuporte.setProximoCadeia(diretorOperacoes);
        diretorOperacoes.setProximoCadeia(ceo);
        ceo.setProximoCadeia(null);
        
        Reembolso reembolso = new Reembolso();
        reembolso.setDescricao("compra");
        reembolso.setValor(1200d);

        suporteTecnico.autoriza(reembolso);
    }
}
