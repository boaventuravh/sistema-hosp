package pweb.sistemahospitalar.dtos.update.medico;

import jakarta.validation.Valid;
import pweb.sistemahospitalar.model.geral.EnderecoModel;

public record MedicoUpdateRecordDto(String nome, String telefone, @Valid EnderecoModel endereco) {
}
