package pweb.sistemahospitalar.model.medico;

import java.util.UUID;

//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
public class Especialidade {

    private UUID id;
    private String nomeEspecialidade;

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
