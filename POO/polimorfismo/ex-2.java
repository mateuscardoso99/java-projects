class Funcionario {
    private String nome;
    private double salario;

    public String getNome(){
        return nome;
    }

    public void setNome(String n){
        nome = n;
    }

    public double getSalario(){
        return this.salario;
    }

    public void setSalario(double s){
        salario = s;
    }

    public double getBonificacao() {
        return this.salario + 6000 + 1000;
    }
}

class Gerente extends Funcionario{
    private int idade;

    public int getIdade(){
        return idade;
    }

    public void setIdade(int i){
        idade = i;
    }

    @Override //reescrita de um métododa classe mãe
    public double getBonificacao() {
        return super.getBonificacao() + 1000;
    }

    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        gerente.setIdade(34);
        gerente.setNome("maria");
        gerente.setSalario(2000);
        System.out.println("nome Gerente: "+gerente.getNome()+" idade: "+gerente.getIdade());

        Funcionario f = new Funcionario();
        f.setNome("joao");
        f.setSalario(2000);
        System.out.println("nome Funcionario: "+f.getNome());

        //polimorfismo

        /**
         * O que guarda	uma	variável do	tipo Funcionario? Uma referência para um Funcionario, nunca	o objeto em	si.
        Na herança, vimos que todo Gerente é um Funcionario, pois é uma	extensão deste. Podemos nos referir	a um Gerente
        como sendo um Funcionario. Se alguém precisa falar com um Funcionario do banco,	pode falar com um Gerente! Porque?
        Pois Gerente é um Funcionario. Essa é a	semântica da herança.
        Polimorfismo é a capacidade de um objeto poder ser referenciado de várias formas.
        (polimorfismo não quer	dizer que o	objeto fica	se transformando, muito	pelo contrário, um objeto nasce
        de um tipo e morre daquele tipo, o que pode	mudar é	a maneira como nos referimos a ele
         */
        Funcionario f2 = new Gerente();
        f2.setNome("carlos");
        f2.setSalario(3000);
    

        Funcionario f3;
        f3 = gerente;
        f3.setSalario(10000);
        
        //No Java, a invocação de método sempre vai ser decidida em tempo de execução. O Java vai procurar o objeto	na memória e, aí sim
        //decidir qual método deve ser chamado, sempre relacionando com sua classe de verdade, e não com a que estamos usando para referenciá-lo
        //Apesar de	estarmos nos referenciando a esse Gerente como sendo um Funcionario, o método executado é o do Gerente
        System.out.println(f3.getBonificacao());
        
        /*
         Funcionario f2 = new Gerente();
         f2.setNome("carlos");
         f2.setSalario(3000);
         
         VAI SER INVOCADO O METODO DO GERENTE, MESMO QUE f2 SEJA DO TIPO FUNCIONARIO ELE RECEBE
         UMA INSTANCIA DE GERENTE ENTAO SERÁ CHAMADO O METODO QUE ESTA NA CLASSE GERENTE
        */
    }
}
