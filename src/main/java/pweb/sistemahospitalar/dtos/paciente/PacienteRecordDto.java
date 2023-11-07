package pweb.sistemahospitalar.dtos.paciente;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;

public record PacienteRecordDto(@NotNull String nome, @NotNull String email, @NotNull String telefone, @NotNull StatusPessoaModel status, @NotNull EnderecoModel endereco, @NotNull String cpf) {
}
