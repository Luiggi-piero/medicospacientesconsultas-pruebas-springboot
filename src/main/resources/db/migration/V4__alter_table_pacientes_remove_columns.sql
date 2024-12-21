alter table pacientes drop column urbanizacion;
alter table pacientes drop column codigo_postal;
alter table pacientes drop column provincia;
alter table pacientes add calle varchar(100) not null;