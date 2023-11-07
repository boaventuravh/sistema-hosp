package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "STATUS_CONSULTA")
public class StatusConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;
    @OneToOne(mappedBy = "statusConsulta")
    private ConsultaModel consultaModel;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ConsultaModel getConsulta() {
        return consultaModel;
    }

    public void setConsulta(ConsultaModel consultaModel) {
        this.consultaModel = consultaModel;
    }
}
