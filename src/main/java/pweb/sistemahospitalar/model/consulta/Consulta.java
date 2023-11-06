package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.medico.Medico;
import pweb.sistemahospitalar.model.paciente.Paciente;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CONSULTA")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @OneToOne(mappedBy = "consulta")
    private Cancelamento cancelamento;
    private Date dataHora;
    @OneToOne
    @JoinColumn(name = "status_consulta")
    private StatusConsulta statusConsulta;

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public UUID getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
