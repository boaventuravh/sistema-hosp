package pweb.sistemahospitalar.service;

import pweb.sistemahospitalar.model.abstratas.PessoaModel;

import java.util.Comparator;

public class OrdenaPessoaPorNome implements Comparator<PessoaModel> {
    @Override
    public int compare(PessoaModel p1, PessoaModel p2) {
        return String.CASE_INSENSITIVE_ORDER.compare(p1.getNome(), p2.getNome());
    }
}
