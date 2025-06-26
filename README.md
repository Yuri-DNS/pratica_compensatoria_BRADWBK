# Professors GraphQL API

API de cadastro de professores usando Spring Boot, MongoDB e GraphQL.

## Funcionalidades

- Listar todos os professores
- Buscar professor por ID
- Criar professor
- Atualizar professor
- Deletar professor

## Como rodar

1. Configure o MongoDB em `src/main/resources/application.properties`
2. Execute o projeto:

```bash
./mvnw spring-boot:run
```

3. Acesse o playground GraphiQL em:  
`http://localhost:8080/graphiql`

## Exemplos de Queries

**Listar todos os professores**
```graphql
query {
  professors {
    id
    name
    email
  }
}
```

**Buscar professor por ID**
```graphql
query {
  professor(id: "ID_DO_PROFESSOR") {
    id
    name
    email
  }
}
```

**Criar professor**
```graphql
mutation {
  createProfessor(name: "Nome", email: "email@ifsp.edu.br") {
    id
    name
    email
  }
}
```

**Atualizar professor**
```graphql
mutation {
  updateProfessor(id: "ID_DO_PROFESSOR", name: "Novo Nome", email: "novo@ifsp.edu.br") {
    id
    name
    email
  }
}
```

**Deletar professor**
```graphql
mutation {
  deleteProfessor(id: "ID_DO_PROFESSOR")
}
```
