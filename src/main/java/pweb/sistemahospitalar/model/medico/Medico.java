package pweb.sistemahospitalar.model.medico;

import pweb.sistemahospitalar.model.abstratas.Pessoa;

import java.util.UUID;


public class Medico extends Pessoa {

    private String crm;
    private UUID especialidadeId;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public UUID getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(UUID especialidadeId) {
        this.especialidadeId = especialidadeId;
    }


    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public void setEnderecoId(UUID enderecoId) {
        this.enderecoId = enderecoId;
    }

    @Override
    public UUID getEnderecoId() {
        return this.enderecoId;
    }

    @Override
    public UUID getStatusId() {
        return this.statusId;
    }

    @Override
    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }
}
