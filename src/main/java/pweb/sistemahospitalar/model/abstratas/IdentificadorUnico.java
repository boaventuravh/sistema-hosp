package pweb.sistemahospitalar.model.abstratas;

import java.util.UUID;

public abstract class IdentificadorUnico {

    protected UUID id;
    protected String digitos;


    public abstract UUID getId();
    public abstract void setId(UUID id);
    public abstract String getDigitos();
    public abstract void setDigitos(String digitos);

}
