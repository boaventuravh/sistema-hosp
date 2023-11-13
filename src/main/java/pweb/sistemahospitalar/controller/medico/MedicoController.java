package pweb.sistemahospitalar.controller.medico;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pweb.sistemahospitalar.dtos.completo.medico.MedicoRecordDto;
import pweb.sistemahospitalar.dtos.listagem.MedicoListRecordDto;
import pweb.sistemahospitalar.dtos.update.medico.MedicoUpdateRecordDto;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.repositories.geral.EnderecoRepository;
import pweb.sistemahospitalar.repositories.geral.StatusPessoaRepository;
import pweb.sistemahospitalar.repositories.medico.EspecialiadadeRepository;
import pweb.sistemahospitalar.repositories.medico.MedicoRepository;
import pweb.sistemahospitalar.service.OrdenaPessoaPorNome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    StatusPessoaRepository statusRepository;
    @Autowired
    EspecialiadadeRepository especialiadadeRepository;

    @PostMapping("/medico")
    @Transactional
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody @Valid MedicoRecordDto medicoRecordDto){

        if(especialiadadeRepository.findByDescricao(medicoRecordDto.especialidade().getDescricao()) == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        var medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoRecordDto, medicoModel);
        medicoModel.setStatus(statusRepository.findByDescricao("ativo"));

        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(medicoModel.getEndereco(), enderecoModel);

        enderecoRepository.save(enderecoModel);

        medicoModel.setEndereco(enderecoRepository.getReferenceById(enderecoModel.getId()));
        medicoModel.setEspecialidade(especialiadadeRepository.findByDescricao(medicoRecordDto.especialidade().getDescricao()));

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/medico")
    public ResponseEntity<List<MedicoListRecordDto>> listarMedicos(){
        var listaCompleta = medicoRepository.findAll();

        listaCompleta.removeIf(m -> m.getStatus().getDescricao().equalsIgnoreCase("inativo"));
        listaCompleta.sort(new OrdenaPessoaPorNome());

        List<MedicoListRecordDto> listaFiltrada = new ArrayList<>();

        for(MedicoModel m : listaCompleta){
            listaFiltrada.add(new MedicoListRecordDto(m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade().getDescricao()));
        }

        return ResponseEntity.status(HttpStatus.OK).body(listaFiltrada);
    }

    @PutMapping("/medico/{crm}")
    @Transactional
    public ResponseEntity<Object> atualizaMedico(@PathVariable(value = "crm") String crm,
                                                 @RequestBody @Valid MedicoUpdateRecordDto medicoUpdateRecordDto){

        Optional<MedicoModel> medicoOptional = Optional.ofNullable(medicoRepository.findByCrm(crm));

        if(medicoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CRM não cadastrado!");
        }

        var medicoModel = medicoOptional.get();
        if (medicoUpdateRecordDto.nome() != null && !medicoUpdateRecordDto.nome().equals(medicoModel.getNome())){
            medicoModel.setNome(medicoUpdateRecordDto.nome());
        }

        if (medicoUpdateRecordDto.telefone() != null && !medicoUpdateRecordDto.telefone().equals(medicoModel.getTelefone())){
            medicoModel.setTelefone(medicoUpdateRecordDto.telefone());
        }

        if (medicoUpdateRecordDto.endereco() != null){
            Optional<EnderecoModel> enderecoOptional = enderecoRepository.findById(medicoModel.getEndereco().getId());
            var enderecoModel = enderecoOptional.get();
            BeanUtils.copyProperties(medicoUpdateRecordDto.endereco(), enderecoModel);
            enderecoRepository.save(enderecoModel);
        }

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível atualizar o cadastro");
        }
    }

    @DeleteMapping("/medico/{crm}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value = "crm") String crm){
        Optional<MedicoModel> medicoOptional = Optional.ofNullable(medicoRepository.findByCrm(crm));

        if(medicoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CRM não cadastrado!");
        }

        var medicoModel = medicoOptional.get();

        medicoModel.setStatus(statusRepository.findByDescricao("inativo"));

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medicoModel));

    }

}
