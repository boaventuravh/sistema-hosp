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
    private MedicoModel medicoModel;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel pacienteModel;
    @OneToOne(mappedBy = "consulta")
    private CancelamentoModel cancelamentoModel;
    private Date dataHora;
    @OneToOne
    @JoinColumn(name = "status_consulta")
    private StatusConsultaModel statusConsultaModel;

    public StatusConsultaModel getStatusConsulta() {
        return statusConsultaModel;
    }

    public void setStatusConsulta(StatusConsultaModel statusConsultaModel) {
        this.statusConsultaModel = statusConsultaModel;
    }

    public UUID getId() {
        return id;
    }

    public MedicoModel getMedico() {
        return medicoModel;
    }

    public void setMedico(MedicoModel medicoModel) {
        this.medicoModel = medicoModel;
    }

    public PacienteModel getPaciente() {
        return pacienteModel;
    }

    public void setPaciente(PacienteModel pacienteModel) {
        this.pacienteModel = pacienteModel;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
