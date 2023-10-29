package pweb.sistemahospitalar.model.medico;

import pweb.sistemahospitalar.model.abstratas.IdentificadorUnico;

public class CRM extends IdentificadorUnico {
    public CRM(String digitos) {
        super(digitos);
    }

    @Override
    public String getDigitos() {
        return this.digitos;
    }
}
