package pweb.sistemahospitalar.controller.consulta;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.completo.consulta.ConsultaRecordDto;
import pweb.sistemahospitalar.model.consulta.ConsultaModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;
import pweb.sistemahospitalar.repositories.consulta.ConsultaRepository;
import pweb.sistemahospitalar.repositories.consulta.StatusConsultaRepository;
import pweb.sistemahospitalar.repositories.medico.MedicoRepository;
import pweb.sistemahospitalar.repositories.paciente.PacienteRepository;

import java.util.Optional;

@RestController
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    StatusConsultaRepository statusConsultaRepository;

    @PostMapping("/consulta")
    public ResponseEntity<Object> marcaConsulta(@RequestBody @Valid ConsultaRecordDto consultaRecordDto){

        Optional<MedicoModel> medicoOptional = Optional.ofNullable(medicoRepository.findByCrm(consultaRecordDto.crmMedico()));

        if(medicoOptional.isEmpty() || medicoOptional.get().getStatus().getDescricao().equalsIgnoreCase("inativo")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado!");
        }

        Optional<PacienteModel> pacienteOptional = Optional.ofNullable(pacienteRepository.findByCpf(consultaRecordDto.cpfPaciente()));

        if(pacienteOptional.isEmpty() || pacienteOptional.get().getStatus().getDescricao().equalsIgnoreCase("inativo")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado!");
        }

        var medicoModel = medicoOptional.get();
        var pacienteModel = pacienteOptional.get();

        var consultaModel = new ConsultaModel();
        consultaModel.setStatusConsulta(statusConsultaRepository.findByDescricao("confirmada"));
        consultaModel.setMedico(medicoModel);
        consultaModel.setPaciente(pacienteModel);
        consultaModel.setData(consultaRecordDto.data());
        consultaModel.setHorario(consultaRecordDto.horario());

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaRepository.save(consultaModel));

    }
}
