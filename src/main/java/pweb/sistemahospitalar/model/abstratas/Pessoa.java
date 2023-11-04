package pweb.sistemahospitalar.model.abstratas;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.geral.StatusPessoa;

import java.util.UUID;

@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected UUID id;
    protected String nome;
    protected String email;
    protected String telefone;

    public abstract UUID getId();
    public abstract void setNome(String nome);
    public abstract String getNome();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    public abstract void setTelefone(String telefone);
    public abstract String getTelefone();

}
