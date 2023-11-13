package pweb.sistemahospitalar.repositories.paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.util.UUID;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, UUID> {
    PacienteModel findByCpf(String cpf);
}
