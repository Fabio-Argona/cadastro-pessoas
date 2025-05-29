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
