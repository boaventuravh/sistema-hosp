package pweb.sistemahospitalar.model.paciente;

import pweb.sistemahospitalar.model.abstratas.Pessoa;

import java.util.UUID;

public class Paciente extends Pessoa {

    private UUID cpfId;


    public UUID getCpf() {
        return cpfId;
    }

    public void setCpfId(UUID cpfId){
        this.cpfId = cpfId;
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public void setId(UUID id) {

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
