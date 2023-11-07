package pweb.sistemahospitalar.dtos.medico;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;
import pweb.sistemahospitalar.model.medico.EspecialidadeModel;

public record MedicoRecordDto(@NotNull String nome, @NotNull String email, @NotNull String telefone, @NotNull StatusPessoaModel status, @NotNull EnderecoModel endereco, @NotNull String crm, @NotNull EspecialidadeModel especialidade) {
}
