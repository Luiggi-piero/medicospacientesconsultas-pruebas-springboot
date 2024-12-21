package med.voll.api.domain.medico;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(

        @NotBlank(message = "Nombre es obligatorio") // no es vacío ni null
        String nombre,

        @NotBlank
        @Email  // verifica que sea un email
        String email,

        @NotBlank
        String telefono,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")  // solo números entre 4 y 6 digitos
        String documento,

        @NotNull
        Especialidad especialidad,

        @NotNull
        @Valid  // valida que direccion contenga lo esperado por DatosDireccion
        DatosDireccion direccion
) {
}

