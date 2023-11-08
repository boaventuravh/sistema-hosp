package pweb.sistemahospitalar.dtos.listagem;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.medico.EspecialidadeModel;

public record MedicoListRecordDto(@NotNull String nome, @NotNull String email, @NotNull String crm, @NotNull EspecialidadeModel especialidade) {
}
