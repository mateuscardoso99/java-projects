CREATE TABLE IF NOT EXISTS comentario (
  id bigint not null AUTO_INCREMENT,  
  ordem_servico_id bigint NOT null,
  descricao text not null,
  data_envio datetime not null,
    
  PRIMARY KEY (id)
);

ALTER TABLE comentario ADD CONSTRAINT fk_comentario_ordem_servico FOREIGN KEY (ordem_servico_id) REFERENCES ordem_servico(id)