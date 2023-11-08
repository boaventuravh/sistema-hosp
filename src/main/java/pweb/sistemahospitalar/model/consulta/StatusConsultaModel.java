package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "STATUS_CONSULTA")
public class StatusConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(unique = true)
    private String descricao;
    @OneToMany(mappedBy = "statusConsulta")
    private List<ConsultaModel> consultas;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ConsultaModel> getConsulta() {
        return consultas;
    }

    public void setConsulta(List<ConsultaModel> consultas) {
        this.consultas = consultas;
    }
}
