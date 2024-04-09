package org.example;

public class ClasseExemplo {
    @Validate(message = "cpf inválido") //se tiver essa anotação, valida as demais
    @NotNull
    @Pattern(regex = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "cpf não bate")
    private String cpf;

    @Validate(message = "id inválido")
    @Max(tamanho = 400)
    private long id;

    @Validate(message = "idade inválida")
    @Min(tamanho = 18)
    private int idade;

    @Validate(message = "cnpj inválido")
    @Pattern(regex = "(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)", message = "cnpj não bate")
    private String cnpj;


    public ClasseExemplo(String cpf, long id, int idade, String cnpj) {
        this.cpf = cpf;
        this.id = id;
        this.idade = idade;
        this.cnpj = cnpj;
    }

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    
}
