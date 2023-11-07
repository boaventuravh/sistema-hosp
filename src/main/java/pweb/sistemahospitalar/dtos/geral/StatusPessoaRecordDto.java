package pweb.sistemahospitalar.dtos.geral;

import jakarta.validation.constraints.NotNull;

public record StatusPessoaRecordDto(@NotNull String descricao) {
}
