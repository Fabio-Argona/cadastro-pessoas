# 📦 Pessoa Service - API REST

Este serviço é responsável pelo **cadastro e gerenciamento de pessoas** (proprietários e residentes) de um sistema de controle de condomínio.

---

## 🔐 Autenticação

Este serviço **exige autenticação via JWT**. O token deve ser obtido a partir da API `auth-service`.

Todos os endpoints (exceto os públicos, se existirem) requerem o envio de um token válido no cabeçalho:

```
Authorization: Bearer <seu_token_aqui>
```

---

## 🧑‍💼 Entidade Pessoa

A entidade `Pessoa` representa um usuário do sistema. O JSON armazenado tem a seguinte estrutura:

download coletion insomnia [Uploading Insomnia_colection_pessoa…]()


```json
{
  "pessoaId": "68642fd7-880a-402c-badb-fe8463931c48",
  "nome": "coisa linda Silva",
  "cpf": "43349673691",
  "telefone": "12999939699",
  "email": "zezinh97939a@email.com",
  "role": "ROLE_RESIDENTE",
  "creationTimestamp": "2025-06-06T18:02:36.0632279",
  "updateTimestamp": "2025-06-06T18:02:36.0632279"
}
```

---

## 🚀 Endpoints principais

> Todos os endpoints abaixo exigem `Authorization: Bearer <token_jwt>`

### 🔸 `GET /api/pessoas`

🔍 Retorna uma lista de todas as pessoas cadastradas.

---

### 🔸 `GET /api/pessoas/{id}`

🔍 Retorna os dados de uma pessoa específica por ID.

---

### 🔸 `POST /api/pessoas`

📥 Cria uma nova pessoa.  
**Body esperado (JSON):**

```json
{
  "nome": "João da Silva",
  "cpf": "12345678901",
  "telefone": "12999998888",
  "email": "joao@email.com",
  "role": "ROLE_PROPRIETARIO"
}
```

---

### 🔸 `PUT /api/pessoas/{id}`

✏️ Atualiza os dados de uma pessoa existente.

---

### 🔸 `DELETE /api/pessoas/{id}`

🗑️ Remove uma pessoa do sistema.

---

## 🛡️ Permissões

As permissões são baseadas no campo `role`, que pode ser:

- 🛠️ `ROLE_ADMIN`
- 🏠 `ROLE_PROPRIETARIO`
- 👤 `ROLE_RESIDENTE`

As regras de acesso devem ser controladas via JWT + filtros Spring Security.

---

## 🗄️ Banco de Dados

Este serviço utiliza **PostgreSQL** com a seguinte estrutura:

```sql
CREATE TABLE pessoa (
  pessoa_id UUID PRIMARY KEY,
  nome VARCHAR(255),
  cpf VARCHAR(11) UNIQUE,
  telefone VARCHAR(20),
  email VARCHAR(255),
  role VARCHAR(50),
  creation_timestamp TIMESTAMP,
  update_timestamp TIMESTAMP
);
```

---

## ⚙️ Tecnologias

- ☕ Java 21
- 🌱 Spring Boot 3.5
- 🔐 Spring Security (JWT)
- 🐘 PostgreSQL
- 🛠️ Maven
- 🧪 Swagger (opcional)
- 🐳 Docker (opcional)
- 📩 RabbitMQ (se usado para integração com `auth-service`)

---

## 🔁 Integração com Auth-Service

- A autenticação é feita via token JWT gerado pela API `auth-service`
- O token é validado nos filtros de segurança do `pessoa-service`
- As `roles` definem o acesso aos endpoints protegidos

---

## 📬 Exemplo de requisição com cURL

```bash
curl -X POST http://localhost:8081/api/pessoas \
  -H "Authorization: Bearer eyJhbGciOi..." \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Maria Oliveira",
    "cpf": "98765432100",
    "telefone": "12999997777",
    "email": "maria@teste.com",
    "role": "ROLE_RESIDENTE"
}'
```

---

## 📚 Documentação Swagger

🧭 Acesse em:

```
http://localhost:8081/swagger-ui/index.html
```
![image](https://github.com/user-attachments/assets/fe89cfa2-fa9b-4a34-b9c1-b71633afab81)

---

## 🧾 Licença

Este projeto é de uso interno e acadêmico. Sinta-se livre para contribuir, modificar e adaptar conforme suas necessidades.

---
