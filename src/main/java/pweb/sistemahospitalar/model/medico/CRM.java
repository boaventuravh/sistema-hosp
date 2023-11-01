package pweb.sistemahospitalar.model.medico;

import pweb.sistemahospitalar.model.abstratas.IdentificadorUnico;

import java.util.UUID;

public class CRM extends IdentificadorUnico {


    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getDigitos() {
        return this.digitos;
    }

    @Override
    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }
}
