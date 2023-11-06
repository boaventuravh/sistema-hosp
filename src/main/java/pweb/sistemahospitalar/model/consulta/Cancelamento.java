package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "CANCELAMENTO")
public class Cancelamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;
    private String motivo;

    public UUID getId() {
        return id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
