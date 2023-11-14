package pweb.sistemahospitalar.dtos.completo.consulta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record ConsultaRecordDto(@NotNull String crmMedico, @NotNull String cpfPaciente, @NotNull LocalDate data, @NotNull
                                LocalTime horario) {
}
