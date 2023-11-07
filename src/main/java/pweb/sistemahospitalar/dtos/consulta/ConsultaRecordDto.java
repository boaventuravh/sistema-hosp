package pweb.sistemahospitalar.dtos.consulta;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.consulta.StatusConsultaModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.util.Date;

public record ConsultaRecordDto(@NotNull MedicoModel medicoModel, @NotNull PacienteModel pacienteModel, @NotNull Date dataHora, StatusConsultaModel statusConsultaModel) {
}
