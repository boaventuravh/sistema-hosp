package pweb.sistemahospitalar.model.consulta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "CONSULTA")
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @JsonBackReference(value = "medico_id")
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    @JsonBackReference(value = "paciente_id")
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;
    @OneToOne(mappedBy = "consulta")
    private CancelamentoModel cancelamentoModel;
    private LocalDate data;
    private LocalTime horario;

    @JsonBackReference(value = "status_consulta")
    @ManyToOne
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
