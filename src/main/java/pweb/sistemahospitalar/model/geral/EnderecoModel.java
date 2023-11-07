package pweb.sistemahospitalar.model.geral;

import jakarta.persistence.*;
import pweb.sistemahospitalar.model.abstratas.PessoaModel;

import java.util.UUID;

@Entity
@Table(name = "ENDERECO")
public class EnderecoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    @OneToOne(mappedBy = "endereco")
    private PessoaModel pessoaModel;

    public UUID getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public PessoaModel getPessoa() {
        return pessoaModel;
    }

    public void setPessoa(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }
}
