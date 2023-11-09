package pweb.sistemahospitalar.model.medico;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.PessoaModel;
import pweb.sistemahospitalar.model.consulta.ConsultaModel;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "MEDICO")
public class MedicoModel extends PessoaModel {

    @Column(unique = true)
    private String crm;

    @JsonBackReference(value = "especialidade_id")
    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private EspecialidadeModel especialidade;

    @OneToMany(mappedBy = "medico")
    private List<ConsultaModel> consultas;

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
    public void setEndereco(EnderecoModel enderecoModel) {
        this.endereco = enderecoModel;
    }
    @Override
    public EnderecoModel getEndereco() {
        return this.endereco;
    }
    @Override
    public StatusPessoaModel getStatus() {
        return this.status;
    }
    @Override
    public void setStatus(StatusPessoaModel status) {
        this.status = status;
    }
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public EspecialidadeModel getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeModel especialidadeModel) {
        this.especialidade = especialidadeModel;
    }

    public List<ConsultaModel> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaModel> consultaModels) {
        this.consultas = consultaModels;
    }
}
