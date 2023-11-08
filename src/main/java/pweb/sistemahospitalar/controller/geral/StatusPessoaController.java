package pweb.sistemahospitalar.controller.geral;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.completo.geral.StatusPessoaRecordDto;
import pweb.sistemahospitalar.model.geral.StatusPessoaModel;
import pweb.sistemahospitalar.repositories.geral.StatusPessoaRepository;

@RestController
public class StatusPessoaController {
    @Autowired
    StatusPessoaRepository statusPessoaRepository;

    @PostMapping("/statuspessoa")
    public ResponseEntity<StatusPessoaModel> saveStatusPessoa(@RequestBody @Valid StatusPessoaRecordDto statusPessoaRecordDto){
        var statusPessoaModel = new StatusPessoaModel();
        BeanUtils.copyProperties(statusPessoaRecordDto, statusPessoaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusPessoaRepository.save(statusPessoaModel));
    }
}
