package pweb.sistemahospitalar.model.medico;

import jakarta.persistence.*;

import java.util.UUID;

//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
@Entity
@Table(name = "ESPECIALIDADE")
public class EspecialidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;

    @OneToOne(mappedBy = "especialidade")
    private MedicoModel medicoModel;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public MedicoModel getMedico() {
        return medicoModel;
    }

    public void setMedico(MedicoModel medicoModel) {
        this.medicoModel = medicoModel;
    }
}
