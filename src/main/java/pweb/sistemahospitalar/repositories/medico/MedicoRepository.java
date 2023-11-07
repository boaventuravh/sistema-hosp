package pweb.sistemahospitalar.repositories.medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.medico.MedicoModel;

import java.util.UUID;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, UUID> {
}
