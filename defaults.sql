create database webhook;

SET TIME ZONE 'America/Sao_Paulo';


create table usuario(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name text,
    number text,
    created_at timestamp with time zone default now()
);

create table youtube(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    url text,
    idUsuario INTEGER,
    constraint fk_cliente foreign key (idUsuario) references usuario(id)
);


SELECT * from usuario;