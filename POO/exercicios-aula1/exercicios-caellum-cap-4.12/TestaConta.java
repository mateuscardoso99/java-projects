public class TestaConta {
    public static void main(String[] args) {
        Conta conta1 = new Conta();
        conta1.numero = 4456;
        conta1.saldo = 1000;
        conta1.dataAbertura.ano = 1997;
        conta1.dataAbertura.mes = 07;
        conta1.dataAbertura.dia = 29;

        Conta conta2 = new Conta();
        conta2.numero = 2910;
        conta2.saldo = 2993;
        conta2.dataAbertura.ano = 2002;
        conta2.dataAbertura.mes = 05;
        conta2.dataAbertura.dia = 12;

        Conta conta3 = new Conta();
        conta3.numero = 440;
        Conta conta4 = conta3;

        //true porque conta4 e conta3 fazem referencia pro mesmo objeto na memoria
        if(conta3 == conta4){
            System.out.println("conta3 == conta4: true");
        }

        //Conta.numero = 7; //para funcionar atributo numero deve ser estatico ou seja, ser um atributo da classe

        Cliente c1 = new Cliente();
        c1.nome = "joao";
        c1.cpf = "453.266.764-88";
        c1.sobrenome = "silva";

        Cliente c2 = new Cliente();
        c2.nome = "carlos";
        c2.cpf = "949.099.532-67";
        c2.sobrenome = "lopes";

        conta1.titular = c1;
        conta2.titular = c2;

        System.out.println(conta1.recuperaDadosImpressao());
        System.out.println(conta2.recuperaDadosImpressao());

        conta1.depositar(204);

        System.out.println(conta1.recuperaDadosImpressao());
        System.out.println("204 depositado na conta1 (joao)");
        
        if(!conta2.sacar(100)){
            System.out.println("\nerro saque 100 conta 2 (carlos), saldo insuficiente");
        }
        else{
            System.out.println("\nsaque de 100 da conta2 (carlos) feito com sucesso");
        }

        System.out.println(conta2.recuperaDadosImpressao());

        if(!conta2.sacar(3000)){
            System.out.println("erro saque de 3000 conta 2 (carlos), saldo insuficiente");
        }
        else{
            System.out.println("saque de 3000 da conta2 (carlos) feito com sucesso");
        }
        
        System.out.println(conta2.recuperaDadosImpressao());

        if(!conta1.transferePara(conta2, 120)){
            System.out.println("erro transferir 120 conta1 (joao) pra conta 2 (carlos), saldo insuficiente");
        }
        else{
            System.out.println("120 transferido da conta1 (joao) pra conta2 (carlos)");
        }

        System.out.println(conta1.recuperaDadosImpressao());
        System.out.println(conta2.recuperaDadosImpressao());

        if(!conta1.transferePara(conta2, 12000)){
            System.out.println("erro transferir 12000 conta1 (joao) pra conta 2 (carlos), saldo insuficiente");
        }
        else{
            System.out.println("12000 transferido da conta1 (joao) pra conta2 (carlos)");
        }

        System.out.println(conta1.recuperaDadosImpressao());
        System.out.println(conta2.recuperaDadosImpressao());
    }
}
