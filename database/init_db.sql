CREATE TABLE IF NOT EXISTS usuario (
	usuario_id serial PRIMARY KEY,
	nome VARCHAR(127),
	senha VARCHAR(63)
);

CREATE TABLE IF NOT EXISTS tarefa (
	tarefa_id serial PRIMARY KEY,
	titulo VARCHAR(50) NULL,
	descricao VARCHAR(255),
	prioridade VARCHAR(16),
	concluida BOOLEAN,
	usuario_id INT,
	CONSTRAINT usuario_id
		FOREIGN KEY(usuario_id)
			REFERENCES usuario(usuario_id)
);
