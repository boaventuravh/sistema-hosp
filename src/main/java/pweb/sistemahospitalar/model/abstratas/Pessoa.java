package pweb.sistemahospitalar.model.abstratas;

import pweb.sistemahospitalar.model.geral.Endereco;

public abstract class Pessoa {

    protected String nome;
    protected String email;
    protected String telefone;
    protected Endereco endereco;

    public Pessoa(){}

    public Pessoa(String nome, String email, String telefone, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public abstract String getNome();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    public abstract void setTelefone(String telefone);
    public abstract String getTelefone();
    public abstract void setEndereco(Endereco endereco);
    public abstract Endereco getEndereco();
}
