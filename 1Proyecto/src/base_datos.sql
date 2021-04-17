CREATE DATABASE BancaPrestamo;

use BancaPrestamo;

create table Usuario (
       id  varchar(10)  not null,
       nombre varchar(40) not null,
       clave varchar(10) not null,
       rol varchar(10) not null, 
       correo varchar(25) not null,
       telefono double not null,       
       Primary Key (id)         
     );

create table Cliente (
       id  varchar(10)  not null,
       nombre varchar(30) not null,  
       Primary Key (id)         
     );


create table Prestamo (
    numero varchar(10)  not null,
    monto double,
    tasa double,
    plazo double,
    cliente varchar(10),
    Primary Key (numero)
);

ALTER TABLE Prestamo ADD Foreign Key (cliente) REFERENCES Cliente(id);

insert into Usuario (id,clave,rol) values ('111','111','ADM');
