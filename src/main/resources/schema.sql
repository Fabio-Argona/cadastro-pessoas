CREATE TABLE pessoa (
    pessoa_id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,  -- ESSENCIAL para autenticação
    role VARCHAR(50) NOT NULL,
    creation_timestamp TIMESTAMP NOT NULL,
    update_timestamp TIMESTAMP NOT NULL
);
