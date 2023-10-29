package pweb.sistemahospitalar.model.abstratas;

public abstract class IdentificadorUnico {
    protected String digitos;

    public IdentificadorUnico(String digitos){
        this.digitos = digitos;
    }
    public abstract String getDigitos();

}
