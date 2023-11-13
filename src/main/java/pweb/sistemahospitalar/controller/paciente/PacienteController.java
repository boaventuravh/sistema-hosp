package pweb.sistemahospitalar.controller.paciente;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pweb.sistemahospitalar.dtos.completo.paciente.PacienteRecordDto;
import pweb.sistemahospitalar.dtos.update.PessoaUpdateRecordDto;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;
import pweb.sistemahospitalar.repositories.geral.EnderecoRepository;
import pweb.sistemahospitalar.repositories.geral.StatusPessoaRepository;
import pweb.sistemahospitalar.repositories.paciente.PacienteRepository;

import java.util.Optional;

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

    @PutMapping("/paciente/{cpf}")
    @Transactional
    ResponseEntity<Object> atualizaPaciente(@PathVariable(value = "cpf") String cpf,
                                            @RequestBody @Valid PessoaUpdateRecordDto pacienteUpdateRecordDto){
        Optional<PacienteModel> pacienteOptional = Optional.ofNullable(pacienteRepository.findByCpf(cpf));

        if(pacienteOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não cadastrado!");
        }

        var pacienteModel = pacienteOptional.get();
        if (pacienteUpdateRecordDto.nome() != null && !pacienteUpdateRecordDto.nome().equals(pacienteModel.getNome())){
            pacienteModel.setNome(pacienteUpdateRecordDto.nome());
        }

        if (pacienteUpdateRecordDto.telefone() != null && !pacienteUpdateRecordDto.telefone().equals(pacienteModel.getTelefone())){
            pacienteModel.setTelefone(pacienteUpdateRecordDto.telefone());
        }

        if (pacienteUpdateRecordDto.endereco() != null){
            Optional<EnderecoModel> enderecoOptional = enderecoRepository.findById(pacienteModel.getEndereco().getId());
            var enderecoModel = enderecoOptional.get();
            BeanUtils.copyProperties(pacienteUpdateRecordDto.endereco(), enderecoModel);
            enderecoRepository.save(enderecoModel);
        }

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteModel));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível atualizar o cadastro");
        }

    }
}
