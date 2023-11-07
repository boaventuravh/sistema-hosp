package pweb.sistemahospitalar.dtos.consulta;

import jakarta.validation.constraints.NotBlank;

public record StatusConsultaRecordDto(@NotBlank String descricao) {
}
