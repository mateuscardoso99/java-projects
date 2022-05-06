
package newpackage;

public class Cliente {
    private String nomeCliente;
    private String email;
    private String cpf;
    private String telefone;
    private String dataAniversario;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String email, String cpf, String telefone, String dataAniversario) {
        this.nomeCliente = nomeCliente;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataAniversario = dataAniversario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
    
}
