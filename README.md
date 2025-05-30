# cadastro-pessoas
Cadastro de Pessoas Proprietário, Residente e Administrador

✅ Todas as classes do módulo cadastro-pessoas-service foram criadas seguindo a mesma estrutura modular do auth-service.

Inclui:

Controller: PessoaController

DTOs: PessoaRequest, PessoaResponse, ImovelDTO

Entidades: Pessoa, Imovel

Enums: TipoPessoa (para distinguir entre PROPRIETARIO e RESIDENTE)

Repositórios: PessoaRepository, ImovelRepository

Serviço: PessoaService

application.yml com configurações do banco PostgreSQL

Se quiser que eu gere os endpoints REST no Postman, Swagger ou uma UI simples em Angular para visualizar e editar conforme as roles (ROLE_PROPRIETARIO, ROLE_RESIDENTE, ROLE_ADMIN), posso fazer também. Deseja seguir para isso?

| Role                | Acesso             | Pode editar? | Pode cadastrar? |
| ------------------- | ------------------ | ------------ | --------------- |
| `ROLE_ADMIN`        | Todos os cadastros | Sim          | Sim             |
| `ROLE_PROPRIETARIO` | Apenas seus dados  | Sim          | Não             |
| `ROLE_RESIDENTE`    | Apenas seus dados  | Sim          | Não             |

Endpoints que você tem (pelos controllers):
Recurso	Método	URL	Descrição
Pessoas	GET	/pessoas	Lista todas as pessoas
Proprietários	GET	/proprietarios	Lista todos os proprietários
Proprietários	POST	/proprietarios	Cria um novo proprietário
Residentes	GET	/residentes	Lista todos os residentes
Residentes	POST	/residentes	Cria um novo residente

1. Listar todos (GET)
Exemplo para listar todos os proprietários:
Método: GET

URL: http://localhost:8081/proprietarios

Sem corpo, só fazer a requisição.

2. Criar um Proprietário (POST)
URL:
http://localhost:8081/proprietarios

Corpo (JSON):
json
Copiar
Editar
{
  "nome": "João da Silva",
  "cpf": "12345678901",
  "telefone": "11999999999",
  "email": "joao.silva@email.com",
  "imoveisVinculados": ["Apt 101", "Casa 202"]
}
3. Criar um Residente (POST)
URL:
http://localhost:8081/residentes

Corpo (JSON):
json
Copiar
Editar
{
  "nome": "Maria Oliveira",
  "cpf": "10987654321",
  "telefone": "11988888888",
  "email": "maria.oliveira@email.com",
  "imovelAtual": "Apt 101"
}
4. Listar Residentes (GET)
URL: http://localhost:8081/residentes

5. Listar Pessoas (GET)
URL: http://localhost:8081/pessoas

Dica para usar no Insomnia/Postman:
Para GET: basta colocar a URL e mandar a requisição.

Para POST: selecione método POST, cole a URL e no corpo (Body) escolha JSON e cole o JSON do exemplo acima.


-- Tabela pessoa (base para proprietários e residentes)
CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(255)
);

-- Tabela proprietario (extensão de pessoa)
CREATE TABLE proprietario (
    id SERIAL PRIMARY KEY,
    pessoa_id INTEGER NOT NULL UNIQUE REFERENCES pessoa(id) ON DELETE CASCADE,
    -- Os imóveis vinculados aqui são uma lista, então vamos usar uma tabela separada para armazenar vários imóveis
    -- Logo, só deixamos o id para a relação
    -- Vamos criar uma tabela para os imóveis vinculados abaixo
);

-- Tabela para os imóveis vinculados ao proprietário
CREATE TABLE imovel_vinculado (
    id SERIAL PRIMARY KEY,
    proprietario_id INTEGER NOT NULL REFERENCES proprietario(id) ON DELETE CASCADE,
    descricao VARCHAR(255) NOT NULL
);

-- Tabela residente (extensão de pessoa)
CREATE TABLE residente (
    id SERIAL PRIMARY KEY,
    pessoa_id INTEGER NOT NULL UNIQUE REFERENCES pessoa(id) ON DELETE CASCADE,
    imovel_atual VARCHAR(255)
);

-- Inserir pessoas
INSERT INTO pessoa (nome, cpf, telefone, email) VALUES
('João da Silva', '12345678901', '11999999999', 'joao.silva@email.com'),
('Maria Oliveira', '10987654321', '11988888888', 'maria.oliveira@email.com');

-- Inserir proprietario associando pessoa (exemplo João)
INSERT INTO proprietario (pessoa_id) 
SELECT id FROM pessoa WHERE cpf = '12345678901';

-- Inserir imoveis vinculados para o proprietario
INSERT INTO imovel_vinculado (proprietario_id, descricao)
SELECT p.id, 'Apt 101' FROM proprietario p
JOIN pessoa pe ON pe.id = p.pessoa_id
WHERE pe.cpf = '12345678901';

INSERT INTO imovel_vinculado (proprietario_id, descricao)
SELECT p.id, 'Casa 202' FROM proprietario p
JOIN pessoa pe ON pe.id = p.pessoa_id
WHERE pe.cpf = '12345678901';

-- Inserir residente associando pessoa (exemplo Maria)
INSERT INTO residente (pessoa_id, imovel_atual) 
SELECT id, 'Apt 101' FROM pessoa WHERE cpf = '10987654321';


