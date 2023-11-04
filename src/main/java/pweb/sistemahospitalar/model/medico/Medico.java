package pweb.sistemahospitalar.model.medico;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pweb.sistemahospitalar.model.abstratas.Pessoa;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.UUID;

@Entity
@Table(name = "MEDICO")
public class Medico extends Pessoa {

    private String crm;
    private Especialidade especialidade;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private StatusPessoa status;

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

    public StatusPessoa getStatus() {
        return this.status;
    }

    public void setStatus(StatusPessoa status) {
        this.status = status;
    }
}
