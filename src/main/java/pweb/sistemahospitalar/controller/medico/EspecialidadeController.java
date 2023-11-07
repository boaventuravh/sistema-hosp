package pweb.sistemahospitalar.controller.medico;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.medico.EspecialidadeRecordDto;
import pweb.sistemahospitalar.model.medico.EspecialidadeModel;
import pweb.sistemahospitalar.repositories.medico.EspecialiadadeRepository;

@RestController
public class EspecialidadeController {

    @Autowired
    EspecialiadadeRepository especialiadadeRepository;

    @PostMapping("/especialidade")
    public ResponseEntity<EspecialidadeModel> saveEspecialiadade(@RequestBody @Valid EspecialidadeRecordDto especialidadeRecordDto){
        var especialidadeModel = new EspecialidadeModel();
        BeanUtils.copyProperties(especialidadeRecordDto, especialidadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(especialiadadeRepository.save(especialidadeModel));
    }
}
