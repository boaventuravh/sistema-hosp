package pweb.sistemahospitalar.model.paciente;

import pweb.sistemahospitalar.model.abstratas.Pessoa;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.UUID;

public class Paciente extends Pessoa {

    private String cpf;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public void setId(UUID id) {

    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public void setStatus(StatusPessoa status) {
        this.status = status;
    }

    @Override
    public StatusPessoa getStatus() {
        return this.status;
    }
}
