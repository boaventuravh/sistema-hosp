package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "CANCELAMENTO")
public class CancelamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "consulta_id")
    private ConsultaModel consulta;
    private String motivo;

    public UUID getId() {
        return id;
    }

    public ConsultaModel getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaModel consultaModel) {
        this.consulta = consultaModel;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
