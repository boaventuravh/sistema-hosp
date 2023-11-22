package pweb.sistemahospitalar.controller.consulta;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pweb.sistemahospitalar.dtos.completo.consulta.CancelamentoRecordDto;
import pweb.sistemahospitalar.dtos.completo.consulta.ConsultaRecordDto;
import pweb.sistemahospitalar.model.consulta.CancelamentoModel;
import pweb.sistemahospitalar.model.consulta.ConsultaModel;
import pweb.sistemahospitalar.model.medico.MedicoModel;
import pweb.sistemahospitalar.model.paciente.PacienteModel;
import pweb.sistemahospitalar.repositories.consulta.CancelamentoRepository;
import pweb.sistemahospitalar.repositories.consulta.ConsultaRepository;
import pweb.sistemahospitalar.repositories.consulta.StatusConsultaRepository;
import pweb.sistemahospitalar.repositories.medico.MedicoRepository;
import pweb.sistemahospitalar.repositories.paciente.PacienteRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Autowired
    CancelamentoRepository cancelamentoRepository;

    @PostMapping("/consulta")
    public ResponseEntity<Object> marcaConsulta(@RequestBody @Valid ConsultaRecordDto consultaRecordDto){

        Optional<MedicoModel> medicoOptional = Optional.ofNullable(medicoRepository.findByCrm(consultaRecordDto.crmMedico()));

        if(medicoOptional.isEmpty() || medicoOptional.get().getStatus().getDescricao().equalsIgnoreCase("inativo")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Médico não encontrado!");
        }

        Optional<PacienteModel> pacienteOptional = Optional.ofNullable(pacienteRepository.findByCpf(consultaRecordDto.cpfPaciente()));

        if(pacienteOptional.isEmpty() || pacienteOptional.get().getStatus().getDescricao().equalsIgnoreCase("inativo")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente não encontrado!");
        }

        if(consultaRepository.existsByPacienteAndData(pacienteRepository.findByCpf(consultaRecordDto.cpfPaciente()), consultaRecordDto.data())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não é possível marcar duas consultas no mesmo dia para o mesmo paciente!");
        }

        if (consultaRepository.
                existsByMedicoAndDataAndHorario(medicoRepository.
                        findByCrm(consultaRecordDto.crmMedico()),consultaRecordDto.data(),consultaRecordDto.horario()))
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O médico selecionado não está disponível nesse horário");
        }

        // o último horário disponível é 18:00, pois a clínica encerra o funcionamento às 19:00
        // caso uma consulta seja marcada após as 18:00, ela ultrapassa o horário de funcionamento,
        // pois cada consulta dura uma hora
        if(consultaRecordDto.data().getDayOfWeek().equals(DayOfWeek.SUNDAY) ||
            consultaRecordDto.horario().isBefore(LocalTime.of(7, 0)) ||
            consultaRecordDto.horario().isAfter(LocalTime.of(18, 0)) ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data ou horário fora do período de funcionamento da clínica!");
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

    @DeleteMapping("/consulta")
    @Transactional
    public ResponseEntity<Object> cancelaConsulta(@RequestBody @Valid CancelamentoRecordDto cancelamentoRecordDto){

        Optional<ConsultaModel> consultaOptional = consultaRepository.findById(cancelamentoRecordDto.consultaId());

        if(consultaOptional.isEmpty() || consultaOptional.get().getStatusConsulta().getDescricao().equalsIgnoreCase("cancelada")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não encontrada!");
        }

        LocalDate hoje = LocalDate.now();
        LocalTime horarioAtual = LocalTime.now();

        if(!(hoje.isBefore(consultaOptional.get().getData()) &&
                horarioAtual.isBefore(consultaOptional.get().getHorario()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Só é possível cancelar com antecedência mínima de 24 horas!");
        }

        var consultaModel = consultaOptional.get();
        consultaModel.setStatusConsulta(statusConsultaRepository.findByDescricao("cancelada"));

        var cancelamentoModel = new CancelamentoModel();

        cancelamentoModel.setConsulta(consultaModel);
        cancelamentoModel.setMotivo(cancelamentoRecordDto.motivo());

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(cancelamentoRepository.save(cancelamentoModel));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
