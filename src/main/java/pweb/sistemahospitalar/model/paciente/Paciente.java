package pweb.sistemahospitalar.model.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pweb.sistemahospitalar.model.abstratas.Pessoa;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.UUID;

@Entity
@Table(name = "PACIENTE")
public class Paciente extends Pessoa {

    private String cpf;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    protected Endereco endereco;
    protected StatusPessoa status;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
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


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setStatus(StatusPessoa status) {
        this.status = status;
    }

    public StatusPessoa getStatus() {
        return this.status;
    }
}
