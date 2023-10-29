package pweb.sistemahospitalar.model.medico;

import pweb.sistemahospitalar.model.geral.Endereco;
import pweb.sistemahospitalar.model.abstratas.Pessoa;

public class Medico extends Pessoa {

    private CRM crm;
    private Especialidade especialidade;

    public Medico(){}

    public Medico(String nome, String email, String telefone, Endereco endereco, CRM crm) {
        super(nome, email, telefone, endereco);
        this.crm = crm;
    }

    public CRM getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public Endereco getEndereco() {
        return this.endereco;
    }
}
