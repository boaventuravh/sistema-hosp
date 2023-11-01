package pweb.sistemahospitalar.model.abstratas;

import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.UUID;

public abstract class Pessoa {

    protected UUID id;
    protected String nome;
    protected String email;
    protected String telefone;
    protected UUID enderecoId;
    protected UUID statusId;

    public abstract UUID getId();
    public abstract void setId(UUID id);
    public abstract String getNome();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    public abstract void setTelefone(String telefone);
    public abstract String getTelefone();
    public abstract void setEnderecoId(UUID enderecoId);
    public abstract UUID getEnderecoId();
    public abstract UUID getStatusId();
    public abstract void setStatusId(UUID statusId);
}
