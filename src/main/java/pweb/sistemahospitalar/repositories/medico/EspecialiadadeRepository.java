package pweb.sistemahospitalar.repositories.medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.medico.EspecialidadeModel;

import java.util.UUID;

@Repository
public interface EspecialiadadeRepository extends JpaRepository<EspecialidadeModel, UUID> {
}
