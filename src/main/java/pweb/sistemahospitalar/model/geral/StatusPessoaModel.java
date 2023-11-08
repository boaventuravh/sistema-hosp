package pweb.sistemahospitalar.model.geral;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.PessoaModel;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "STATUS_PESSOA")
public class StatusPessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;

    @OneToMany(mappedBy = "status")
    private List<PessoaModel> pessoas;

    public List<PessoaModel> getPessoa() {
        return pessoas;
    }

    public void setPessoa(List<PessoaModel> pessoas) {
        this.pessoas = pessoas;
    }

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
