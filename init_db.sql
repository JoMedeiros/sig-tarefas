CREATE TABLE IF NOT EXISTS tarefa (
	id serial PRIMARY KEY,
	titulo VARCHAR(50) NULL,
	descricao VARCHAR(255),
	prioridade VARCHAR(16),
	concluida BOOLEAN
);
