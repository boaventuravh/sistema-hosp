package pweb.sistemahospitalar.model.medico;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
@Entity
@Table(name = "ESPECIALIDADE")
public class EspecialidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;

    @OneToMany(mappedBy = "especialidade")
    private List<MedicoModel> medicos;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public List<MedicoModel> getMedico() {
        return medicos;
    }

    public void setMedico(List<MedicoModel> medicos) {
        this.medicos = medicos;
    }
}
