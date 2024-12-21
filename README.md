## Descripción del proyecto
API para la gestión de médicos, pacientes y consultas

## Funcionalidades
- [x] Login: user: diego.rojas  pass: 123456
* Obtener el token
- [x] Permitir la siguientes peticiones con el token de autenticación
- [x] Crear médicos
- [x] Crear pacientes
- [x] Actualización de médicos
* Información permitida para actualización: Nombre, Documento, Dirección
* Reglas de negocio:
  * No permitir actualizar: Especialidad, Correo y teléfono

- [x] Actualización de pacientes
* Información permitida para actualización: Nombre, Teléfono, Dirección
* Reglas de negocio:
  * No permitir actualizar: Correo y Documento de identidad

- [x] Eliminar de médicos/pacientes
* El registro no debe ser borrado de la base de datos
* El listado solo debe retornar Médicos activos

- [x] El horario de atención de la clínica es de lunes a sábado, de 7:00 a 19:00
* Solo se pueden crear consultas en este horario

- [x] Las consultas deben programarse con al menos 30 minutos de anticipación
- [x] No permitir crear consultas con pacientes/médicos inactivos/eliminados
- [x] No permitir reservar más de una consulta en el mismo día para el mismo paciente
- [x] No permitir reservar una consulta con un médico que ya tiene otra consulta reservada en la misma fecha/hora
- [x] La elección de un médico es opcional. En caso de que no exista el id, el sistema debe elegir aleatoriamente un médico que esté disponible en la fecha/hora ingresada 

## Colección de peticiones
[Insomnia_voll.zip](https://github.com/user-attachments/files/18219293/Insomnia_voll.zip)

</br>

>[!IMPORTANT]
>* Crea la base de datos con el nombre 'vollmedapi' en MySQL
>* Reemplaza las credenciales de acceso a la bd en el archivo application.properties
>* Ejecuta el proyecto

</br>
</br>

![Static Badge](https://img.shields.io/badge/java-white?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=black)
</br>
![sp](https://img.shields.io/badge/SPRINGBOOT-white?style=for-the-badge&logo=spring&logoColor=white&labelColor=%236DB33F)
</br>
![sp](https://img.shields.io/badge/mysql-white?style=for-the-badge&logo=mysql&logoColor=white&labelColor=4169E1)



