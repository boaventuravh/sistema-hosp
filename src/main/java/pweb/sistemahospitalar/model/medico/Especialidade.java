package pweb.sistemahospitalar.model.medico;
//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
public class Especialidade {

    private String nomeEspecialidade;

    Especialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
