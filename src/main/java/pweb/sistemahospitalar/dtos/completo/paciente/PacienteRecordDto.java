package pweb.sistemahospitalar.dtos.completo.paciente;

import jakarta.validation.constraints.NotNull;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;

public record PacienteRecordDto(@NotNull String nome, @NotNull String email, @NotNull String telefone, @NotNull EnderecoModel endereco, @NotNull String cpf) {
}
