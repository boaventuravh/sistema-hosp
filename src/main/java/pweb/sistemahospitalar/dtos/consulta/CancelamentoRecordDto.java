package pweb.sistemahospitalar.dtos.consulta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.consulta.ConsultaModel;

public record CancelamentoRecordDto(@NotNull ConsultaModel consultaModel, @NotBlank String motivo) {
}
