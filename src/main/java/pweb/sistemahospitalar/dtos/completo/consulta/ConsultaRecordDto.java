package pweb.sistemahospitalar.dtos.completo.consulta;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.util.Date;

public record ConsultaRecordDto(@NotNull String crmMedico, @NotNull String cpfPaciente, @NotNull Date dataHora) {
}
