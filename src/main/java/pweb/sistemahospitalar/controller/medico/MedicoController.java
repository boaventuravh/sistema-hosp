package pweb.sistemahospitalar.controller.medico;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.medico.MedicoRecordDto;
import pweb.sistemahospitalar.model.geral.EnderecoModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.repositories.geral.EnderecoRepository;
import pweb.sistemahospitalar.repositories.medico.MedicoRepository;

@RestController
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping("/medico")
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody @Valid MedicoRecordDto medicoRecordDto){
        var medicoModel = new MedicoModel();
        var enderecoModel = new EnderecoModel();
        BeanUtils.copyProperties(medicoRecordDto, medicoModel);
        BeanUtils.copyProperties(medicoModel.getEndereco(), enderecoModel);
        enderecoRepository.save(enderecoModel);
        medicoModel.setEndereco(enderecoRepository.getReferenceById(enderecoModel.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
    }

}
