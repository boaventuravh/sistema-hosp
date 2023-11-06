package pweb.sistemahospitalar.model.medico;

import jakarta.persistence.*;

import java.util.UUID;

//Ortopedia, Cardiologia, Ginecologia ou Dermatologia
@Entity
@Table(name = "ESPECIALIDADE")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String descricao;

    @OneToOne(mappedBy = "especialidade")
    private Medico medico;

    public UUID getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
