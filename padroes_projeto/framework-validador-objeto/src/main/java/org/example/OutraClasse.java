package org.example;

public class OutraClasse{
    @Validate(message = "nome inválido")
    @NotNull
    private String nome;

    @Validate(message = "idade inválida")
    @Max(tamanho = 100)
    private Long idade;

    @Validate(message = "cep inválido")
    @Pattern(regex = "(^\\d{5}-\\d{3}$)", message = "cep inválido")
    private String cep;

    

    public OutraClasse(String nome, Long idade, String cep) {
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public Long getIdade() {
        return idade;
    }



    public void setIdade(Long idade) {
        this.idade = idade;
    }



    public String getCep() {
        return cep;
    }



    public void setCep(String cep) {
        this.cep = cep;
    }



    public static void main(String[] args) {
        OutraClasse o = new OutraClasse("joao",Long.valueOf(192),"333373-222");
        try {
            new Validador().validate(o);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

    }

    
}
