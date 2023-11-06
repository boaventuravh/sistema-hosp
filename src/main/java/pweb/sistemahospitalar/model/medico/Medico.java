package pweb.sistemahospitalar.model.medico;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.Pessoa;
import pweb.sistemahospitalar.model.consulta.Consulta;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "MEDICO")
public class Medico extends Pessoa {

    private String crm;
    @OneToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medico")
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
    public StatusPessoa getStatus() {
        return this.status;
    }
    @Override
    public void setStatus(StatusPessoa status) {
        this.status = status;
    }
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
