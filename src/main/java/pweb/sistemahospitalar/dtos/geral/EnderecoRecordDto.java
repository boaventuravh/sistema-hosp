package pweb.sistemahospitalar.dtos.geral;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public record EnderecoRecordDto(@NotNull String logradouro, @Null int numero, @Null String complemento, @NotNull String bairro, @NotNull String cidade, @NotNull String estado, @NotNull String cep) {
}
