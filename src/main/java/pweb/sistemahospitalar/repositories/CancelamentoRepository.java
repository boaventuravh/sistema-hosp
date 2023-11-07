package pweb.sistemahospitalar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.consulta.CancelamentoModel;

import java.util.UUID;

@Repository
public interface CancelamentoRepository extends JpaRepository<CancelamentoModel, UUID> {
}
