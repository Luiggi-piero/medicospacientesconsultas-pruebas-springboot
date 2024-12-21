package med.voll.api.controller;

import med.voll.api.domain.consulta.DatosDetalleConsulta;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.consulta.ReservaDeConsultas;
import med.voll.api.domain.medico.Especialidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters // para que funcione JacksonTester
class ConsultaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DatosReservaConsulta> datosReservaConsultaJson;

    @Autowired
    private JacksonTester<DatosDetalleConsulta> datosDetalleConsultaJson;

    @MockBean
    private ReservaDeConsultas reservaDeConsultas;

    // test error 400
    @Test
    @DisplayName("Deberia devolver http 400 cuando la request no tenga datos")
    @WithMockUser
    void reservar_escenario1() throws Exception {
        var response = mvc.perform(post("/consultas"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    // test codigo 200
    @Test
    @DisplayName("Deberia devolver http 200 cuando la request reciba un json valido")
    @WithMockUser
    void reservar_escenario2() throws Exception {

        var fecha = LocalDateTime.now().plusHours(1);
        var especialidad = Especialidad.CARDIOLOGIA;
        var datosDetalle = new DatosDetalleConsulta(null, 5l, 4l, fecha);

        // cuando se acceda al metodo reservar de reservaDeConsultas, se devolvera datosDetalle como json
        when(reservaDeConsultas.reservar(any())).thenReturn(datosDetalle);

        // simula la creacion de la consulta y verifica el contenido sea new DatosReservaConsulta(4l, 3l, fecha, especialidad)
        var response = mvc.perform(post("/consultas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(datosReservaConsultaJson.write(
                        new DatosReservaConsulta(5l, 4l, fecha, especialidad)
                    ).getJson()))
                .andReturn().getResponse();

        var jsonEsperado = datosDetalleConsultaJson.write(
                datosDetalle
        ).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value()); // valida que la api responda un 200
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);  // valida que el json devuelto por la api sea jsonEsperado
    }
}