package pweb.sistemahospitalar.dtos.completo.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CancelamentoRecordDto(@NotNull UUID consultaId, @NotBlank @NotNull String motivo) {
}
