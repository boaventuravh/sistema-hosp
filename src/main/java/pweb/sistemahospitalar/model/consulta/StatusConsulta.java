package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "STATUS_CONSULTA")
public class StatusConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    @OneToOne(mappedBy = "statusConsulta")
    private Consulta consulta;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
