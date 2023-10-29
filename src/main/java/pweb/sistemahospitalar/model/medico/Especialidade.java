package pweb.sistemahospitalar.model.medico;
//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
public enum Especialidade {
    ORTOPEDIA("Ortopedia"),
    CARDIO("Cardiolodia"),
    GINECO("Ginecologia"),
    DERMATO("Dermatologia")
    ;


    private String nomeEspecialidade;

    Especialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
