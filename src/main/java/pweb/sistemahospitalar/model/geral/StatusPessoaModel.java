package pweb.sistemahospitalar.model.geral;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(unique = true)
    private String descricao;

    @JsonManagedReference(value = "status_id")
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
