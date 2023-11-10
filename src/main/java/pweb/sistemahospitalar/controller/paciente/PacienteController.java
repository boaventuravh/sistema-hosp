package pweb.sistemahospitalar.controller.paciente;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.completo.paciente.PacienteRecordDto;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;
import pweb.sistemahospitalar.repositories.geral.EnderecoRepository;
import pweb.sistemahospitalar.repositories.geral.StatusPessoaRepository;
import pweb.sistemahospitalar.repositories.paciente.PacienteRepository;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    StatusPessoaRepository statusRepository;

    @PostMapping("/paciente")
    @Transactional
    public ResponseEntity<PacienteModel> savePaciente(@RequestBody @Valid PacienteRecordDto pacienteRecordDto){
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteRecordDto, pacienteModel);
        pacienteModel.setStatus(statusRepository.findByDescricao("ativo"));

        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(pacienteModel.getEndereco(), enderecoModel);

        enderecoRepository.save(enderecoModel);

        pacienteModel.setEndereco(enderecoRepository.getReferenceById(enderecoModel.getId()));

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteModel));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
