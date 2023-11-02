package pweb.sistemahospitalar.model.consulta;

import pweb.sistemahospitalar.model.medico.Medico;
import pweb.sistemahospitalar.model.paciente.Paciente;

import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class Consulta {
    private UUID id;
    private UUID medicoId;
    private UUID pacienteId;
    private Date dataHora;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(UUID medicoId) {
        this.medicoId = medicoId;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(UUID pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
