package pweb.sistemahospitalar.model.geral;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.PessoaModel;

import java.util.UUID;

@Entity
@Table(name = "STATUS_PESSOA")
public class StatusPessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;

    @OneToOne(mappedBy = "status")
    private PessoaModel pessoaModel;

    public PessoaModel getPessoa() {
        return pessoaModel;
    }

    public void setPessoa(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
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
