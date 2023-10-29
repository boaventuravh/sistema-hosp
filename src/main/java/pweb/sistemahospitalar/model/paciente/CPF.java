package pweb.sistemahospitalar.model.paciente;

import pweb.sistemahospitalar.model.abstratas.IdentificadorUnico;

public class CPF extends IdentificadorUnico {
    public CPF(String digitos) {
        super(digitos);
    }

    @Override
    public String getDigitos() {
        return this.digitos;
    }
}
