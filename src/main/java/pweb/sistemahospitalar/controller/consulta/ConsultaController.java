package pweb.sistemahospitalar.controller.consulta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.repositories.consulta.ConsultaRepository;
import pweb.sistemahospitalar.repositories.medico.MedicoRepository;
import pweb.sistemahospitalar.repositories.paciente.PacienteRepository;

@RestController
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;
}
