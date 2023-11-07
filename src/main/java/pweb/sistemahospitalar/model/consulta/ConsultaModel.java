package pweb.sistemahospitalar.model.consulta;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CONSULTA")
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;
    @OneToOne(mappedBy = "consulta")
    private CancelamentoModel cancelamentoModel;
    private Date dataHora;
    @OneToOne
    @JoinColumn(name = "status_consulta")
    private StatusConsultaModel statusConsulta;

    public StatusConsultaModel getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsultaModel statusConsultaModel) {
        this.statusConsulta = statusConsultaModel;
    }

    public UUID getId() {
        return id;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medicoModel) {
        this.medico = medicoModel;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel pacienteModel) {
        this.paciente = pacienteModel;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
