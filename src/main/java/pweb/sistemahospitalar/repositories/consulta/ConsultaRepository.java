package pweb.sistemahospitalar.repositories.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.consulta.ConsultaModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, UUID> {
    Optional<ConsultaModel> findById(UUID id);
    boolean existsByPacienteAndData(PacienteModel pacienteModel, LocalDate data);

    boolean existsByMedicoAndDataAndHorario(MedicoModel medicoModel, LocalDate data, LocalTime horario);
}
