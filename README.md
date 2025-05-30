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

