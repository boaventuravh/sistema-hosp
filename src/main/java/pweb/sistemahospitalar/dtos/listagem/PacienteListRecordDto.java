package pweb.sistemahospitalar.dtos.listagem;

import jakarta.validation.constraints.NotNull;

public record PacienteListRecordDto(@NotNull String nome, @NotNull String email, @NotNull String cpf) {
}
