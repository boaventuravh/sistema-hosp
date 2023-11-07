package pweb.sistemahospitalar.controller.consulta;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.consulta.StatusConsultaRecordDto;
import pweb.sistemahospitalar.model.consulta.StatusConsultaModel;
import pweb.sistemahospitalar.repositories.consulta.StatusConsultaRepository;

@RestController
public class StatusConsultaController {

    @Autowired
    StatusConsultaRepository statusConsultaRepository;

    @PostMapping("/statusconsulta")
    public ResponseEntity<StatusConsultaModel> saveStatusConsulta(@RequestBody @Valid StatusConsultaRecordDto statusConsultaRecordDto){
        var statusConsultaModel = new StatusConsultaModel();
        BeanUtils.copyProperties(statusConsultaRecordDto, statusConsultaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusConsultaRepository.save(statusConsultaModel));
    }
}
