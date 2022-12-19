/*Entendendo os conceitos de Polimorfismo
Neste exercício você representará uma folha de pagamentos de
empregados. Primeiro construirá uma classe Empregado, nesta classe
terá métodos sobrecarregados ( overloading ) e redefinidos (
overriding ), bem como terá duas classe filhas um
EmpregadoAssalariado e EmpregadoComissionado. Suas classes
filhas terão construtores para que seja possível criar objetos da mesma
já passando informações na hora da criação do objeto.

Passo 1: Crie uma classe pública Empregado no pacote br.csi.model.
Na classe Empregado defina os seguintes atributos abaixo:
private String nome;
private String cpf;
private final float INSALUBRIDADE = 2.21f;
Encapsule os atributos ( métodos get's e set's).

Passo 2: Crie nesta classe Empregado um método construtor e faça
com que este método receba os atributos da classe como parâmetros.

Passo 3: Crie nesta classe Empregado um método publico com valor
de retorno String chamado toString(), dentro deste método retorne o
nome do Empregado e seu CPF.

Passo 4: Crie nesta classe Empregado um método publico com valor
de retorno float chamado salario( ), dentro deste método retorne o
valor 0f.

Passo 5: Crie uma classe pública chamada EmpregadoAssalariado no
mesmo pacote e faça com que esta classe herde de Empregado. Na
classe EmpregadoAssalarioado defina um atributo privado float
salarioMensal e o encapsule (get's e set's).

Passo 6: No construtor da classe EmpregadoAssalariado faça com que
o mesmo repasse os parâmetros que este receber e que devem ser
atribuídos para os atributos da classe Empregado. Use para isto a
referência super( ... ).

Passo 7: No método setSalarioMensal faça um teste para ver se o
mesmo não esta recebendo valores menores que zero, caso esteja
retorne o valor zero somente.

Passo 8: Na classe EmpregadoAssalariado sobrescreva ( overriding )
o método salario( ) da classe Empregado retornando como valor o
método getSalarioMensal() * getINSALUBRIDADE();

Passo 9: Na classe EmpregadoAssalariado sobrescreva ( overriding )
o método toString( ) da classe Empregado retornando o método
toString( ) da superclasse (Empregado ) mais o salário mensal “
super.toString()+salario()”.

Passo 10: Crie um classe pública chamada EmpregadoComissionado
no mesmo pacote e faça com que esta classe herde de Empregado. Na
classe EmpregadoComissionado defina os seguintes atributos abaixo:
private float vendaBrutaMensal;
private float comissao;
Encapsule os atributos ( métodos get's e set's).

Passo 11: No construtor da classe EmpregadoComissionado faça com
que o mesmo repasse os parâmetros que este receber e que devem ser
atribuídos para os atributos da classe Empregado. Use para isto a
referência super( ... ).

Passo 12: Nos métodos setVendaBrutaMensal e setComissao teste se
os mesmos estão recebendo valores menores que zero, caso verdadeiro
retorne zero senão retornar o valor passado pelo parâmetro.

Passo 13: Na classe EmpregadoComissionado sobrescreva (
overriding ) o método salario( ) da classe Empregado retornando
como valor o método
getComissao() * getVendaBrutaMensal() * getINSALUBRIDADE().

Passo 14: Na classe EmpregadoComissionado sobrescreva (
overriding ) o método toString( ) da classe Empregado retornando o
método toString( ) da superclasse mais a comissão e a venda bruta “
super.toString()+getComissao+getVendaBrutaMensal( )+salario”.

Passo 15: Crie um classe chamada FolhaDePagamento que conterá o
método main, nesta classe crie dois objetos EmpregadoAssalariado e
EmpregadoComissionado.

Passo 16: Crie um método público e estático chamado empregados
que utilize os benefícios de varargs “ public static void
empregados(Empregado... empregado)”, dentro deste método permita
que o mesmo chame o método toString( ) de cada Empregado.
*/

import java.text.DecimalFormat;

class Empregado{
    private String nome;
    private String cpf;
    private final double INSALUBRIDADE = 2.21f;
    
    public Empregado(String n,String cpf){
        this.nome = n;
        this.cpf = cpf;
    }
    
    public String getNome(){ return this.nome; }
    public void setNome(String n) { this.nome = n; }
    
    public String getCpf() { return this.cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public double getINSALUBRIDADE() { return this.INSALUBRIDADE; }
    
    public String toString(){ return this.nome + ' ' + this.cpf; }
    public double salario() { return 0f; }
}


class EmpregadoAssalariado extends Empregado{
    private float salarioMensal;
    
    public EmpregadoAssalariado(String nome, String cpf, float salarioMensal){
        super(nome,cpf);
        this.salarioMensal = salarioMensal;
    }
    
    public float getSalarioMensal(){ return this.salarioMensal; }
    public void setSalarioMensal(float s) {
        if(s < 0)
            this.salarioMensal = 0;
            
        this.salarioMensal = s;
    }
    
    @Override
    public double salario(){
        DecimalFormat df = new DecimalFormat("#####.##");
        return Double.parseDouble(df.format(this.getSalarioMensal() * getINSALUBRIDADE()));
    }
    
    @Override
    public String toString(){
        return super.toString() + " salario: " + this.salario();
    }
    
}



class EmpregadoComissionado extends Empregado{
    private float vendaBrutaMensal;
    private float comissao;
    
    public EmpregadoComissionado(String nome, String cpf, float v, float c){
        super(nome,cpf);
        this.vendaBrutaMensal = v;
        this.comissao = c;
    }
    
    public float getVendaBrutaMensal(){ return this.vendaBrutaMensal; }
    public void setVendaBrutaMensal(float v) {
        if(v < 0)
            this.vendaBrutaMensal = 0;
            
        this.vendaBrutaMensal = v;
    }
    
    public float getComissao(){ return this.comissao; }
    public void setComissao(float c) {
        if(c < 0)
            this.comissao = 0;
            
        this.comissao = c;
    }
    
    @Override
    public double salario(){
        DecimalFormat df = new DecimalFormat("#####.##");
        return Double.parseDouble(df.format(this.getComissao() * this.getVendaBrutaMensal() * getINSALUBRIDADE()));
    }
    
    @Override
    public String toString(){
        return super.toString() + ' ' + this.getComissao() + ' ' + this.getVendaBrutaMensal() + " salario: " + this.salario();
    }
}


class Main {
    public static void empregados(Empregado empregado){
        System.out.println(empregado.toString());
    }
    
    public static void main(String[] args) {
        Empregado ea = new EmpregadoAssalariado("joao","343.254.562-54",2000.00f);
        Empregado ec = new EmpregadoComissionado("maria","211.532.754-00",2350.00f,3);
        empregados(ea);
        empregados(ec);
    }
}
