package pweb.sistemahospitalar.dtos.update;

import jakarta.validation.Valid;
import pweb.sistemahospitalar.model.geral.EnderecoModel;

public record PessoaUpdateRecordDto(String nome, String telefone, @Valid EnderecoModel endereco) {
}
