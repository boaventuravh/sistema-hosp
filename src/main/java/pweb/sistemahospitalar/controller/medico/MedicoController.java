package pweb.sistemahospitalar.controller.medico;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.completo.medico.MedicoRecordDto;
import pweb.sistemahospitalar.dtos.listagem.MedicoListRecordDto;
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
        var medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoRecordDto, medicoModel);

        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(medicoModel.getEndereco(), enderecoModel);

        enderecoRepository.save(enderecoModel);

        medicoModel.setEndereco(enderecoRepository.getReferenceById(enderecoModel.getId()));
        medicoModel.setStatus(statusRepository.findByDescricao(medicoRecordDto.status().getDescricao()));
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

}
