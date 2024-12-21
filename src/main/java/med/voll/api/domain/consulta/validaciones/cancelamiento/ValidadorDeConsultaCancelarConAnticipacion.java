package med.voll.api.domain.consulta.validaciones.cancelamiento;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorDeConsultaCancelarConAnticipacion implements ValidadorDeCancelamientoDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void validar(DatosCancelamientoConsulta datos) {
        var consulta = consultaRepository.findById(datos.idConsulta());

        var fechaConsulta = consulta.get().getFecha();
        var ahora = LocalDateTime.now();

        var diferenciaEnHoras = Duration.between(ahora, fechaConsulta).toHours();
        if(diferenciaEnHoras < 24){
            throw new ValidacionException("No puede cancelar una consulta con una anticipación menor a 24 hrs");
        }
    }
}
