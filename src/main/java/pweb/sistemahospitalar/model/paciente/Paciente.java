package pweb.sistemahospitalar.model.paciente;

import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.abstratas.Pessoa;

public class Paciente extends Pessoa {

    private CPF cpf;

    public Paciente() {}

    public Paciente(String nome, String email, String telefone, Endereco endereco, CPF cpf) {
        super(nome, email, telefone, endereco);
        this.cpf = cpf;
    }

    public CPF getCpf() {
        return cpf;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public Endereco getEndereco() {
        return this.endereco;
    }
}
