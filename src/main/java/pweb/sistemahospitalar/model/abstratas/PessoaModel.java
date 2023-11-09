package pweb.sistemahospitalar.model.abstratas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected UUID id;
    protected String nome;
    @Column(unique = true)
    protected String email;
    @Column(unique = true)
    protected String telefone;

    @JsonBackReference(value = "status_id")
    @ManyToOne
    @JoinColumn(name = "status_id")
    protected StatusPessoaModel status;

    @JsonBackReference(value = "endereco_id")
    @OneToOne
    @JoinColumn(name = "endereco_id")
    protected EnderecoModel endereco;

    public abstract UUID getId();
    public abstract void setNome(String nome);
    public abstract String getNome();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    public abstract void setTelefone(String telefone);
    public abstract String getTelefone();
    public abstract EnderecoModel getEndereco();
    public abstract void setEndereco(EnderecoModel enderecoModel);

    public abstract void setStatus(StatusPessoaModel status);
    public abstract StatusPessoaModel getStatus();
}
