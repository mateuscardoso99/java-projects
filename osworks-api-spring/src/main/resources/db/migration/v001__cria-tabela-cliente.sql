CREATE TABLE cliente(
	id bigint NOT null AUTO_INCREMENT,
    nome varchar(60) NOT null,
    email varchar(255) NOT null,
    telefone varchar(20) NOT null,
    
    PRIMARY KEY (id)
);
