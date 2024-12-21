## Descripción del proyecto
API para la administración de médicos y pacientes

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

- [x] Exclusión de médicos/pacientes
* El registro no debe ser borrado de la base de datos
* El listado solo debe retornar Médicos activos


## Colección de peticiones
[Insomnia_vollmedapi.zip](https://github.com/user-attachments/files/18053329/Insomnia_2024-12-08_vollmedapi.zip)

</br>

>[!IMPORTANT]
>* Crea la base de datos con el nombre 'vollmedapi'
>* Reemplaza las credenciales de acceso a la bd en el archivo application.properties
>* Ejecuta el proyecto

</br>
</br>

![Static Badge](https://img.shields.io/badge/java-white?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=black)
</br>
![sp](https://img.shields.io/badge/SPRINGBOOT-white?style=for-the-badge&logo=spring&logoColor=white&labelColor=%236DB33F)
</br>
![sp](https://img.shields.io/badge/mysql-white?style=for-the-badge&logo=mysql&logoColor=white&labelColor=4169E1)



