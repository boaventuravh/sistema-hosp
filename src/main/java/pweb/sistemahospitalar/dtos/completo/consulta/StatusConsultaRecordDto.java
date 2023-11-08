package pweb.sistemahospitalar.dtos.completo.consulta;

import jakarta.validation.constraints.NotBlank;

public record StatusConsultaRecordDto(@NotBlank String descricao) {
}
