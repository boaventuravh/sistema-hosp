package pweb.sistemahospitalar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pweb.sistemahospitalar.model.geral.EnderecoModel;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}
