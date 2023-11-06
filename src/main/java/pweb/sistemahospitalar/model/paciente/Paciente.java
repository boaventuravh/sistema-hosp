package pweb.sistemahospitalar.model.paciente;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.Pessoa;
import pweb.sistemahospitalar.model.consulta.Consulta;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PACIENTE")
public class Paciente extends Pessoa {

    private String cpf;
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

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
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
