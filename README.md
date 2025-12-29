# 📘 Portal de Aprovados

Projeto desenvolvido como parte de um **processo seletivo para Desenvolvedor**, com o objetivo de criar uma aplicação simples de **cadastro de aprovados em concursos públicos**, contendo **backend em Java (Spring Boot)** e integração para upload de imagem.

---

## 🚀 Objetivo do Projeto

Permitir o cadastro de pessoas aprovadas em concursos públicos, contendo:

* Nome
* E-mail
* Telefone
* Concursos aprovados
* Upload de imagem

A aplicação disponibiliza uma API REST para:

* Criar aprovados
* Listar aprovados
* Buscar aprovado por ID

---

## 🧱 Arquitetura do Projeto

O projeto segue uma arquitetura organizada em camadas, facilitando manutenção, escalabilidade e testes.

```
br.com.portalconcurso
│
├── config
│   ├── FileStorageConfig
│   └── WebConfig
│
├── controller
│   ├── AprovadoController
│   └── FileController
│
├── dto
│   ├── request
│   │   └── AprovadoRequestDTO
│   └── response
│       ├── AprovadoResponseDTO
│       └── UploadFileResponseDTO
│
├── infra
│   └── exception
│       ├── handler
│       ├── BadRequestException
│       ├── BusinessException
│       ├── DuplicateResourceException
│       ├── FileStorageException
│       ├── NotFoundException
│       └── ExceptionResponse
│
├── model
│   └── Aprovado
│
├── repository
│   └── AprovadoRepository
│
├── service
│   ├── AprovadoService
│   ├── FileStorageService
│   └── validator
│       └── aprovado
│           └── ValidatorAprovado
│
└── PortalaprovadosApplication
```

---

## 🧠 Tecnologias Utilizadas

<div align="center">

<img src="https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=java" />
<img src="https://img.shields.io/badge/Spring%20Boot-4.x-brightgreen?style=for-the-badge&logo=springboot" />
<img src="https://img.shields.io/badge/Hibernate-JPA-yellow?style=for-the-badge&logo=hibernate" />
<img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql" />
<img src="https://img.shields.io/badge/Maven-Build-blueviolet?style=for-the-badge&logo=apachemaven" />
<img src="https://img.shields.io/badge/REST%20API-JSON-orange?style=for-the-badge" />

</div>

### Tecnologias utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Web**
* **Spring Data JPA / Hibernate**
* **MySQL**
* **Bean Validation**
* **Upload de arquivos (Multipart)**
* **Maven**

---

## 🗄️ Banco de Dados

Banco utilizado: **MySQL**

Configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_portalaprovados?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=admin
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

> ✅ O banco e as tabelas são criados automaticamente ao subir a aplicação.

---

## 📁 Upload de Imagens

Configuração:

```properties
file.upload-dir=/code/uploadir
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=200MB
spring.servlet.multipart.max-request-size=15MB
```

As imagens são armazenadas localmente no diretório configurado.

---

## 🌐 CORS

```properties
cors.originPatterns=http://localhost:8080,http://127.0.0.1:5500
```

Permite integração com front-end local (HTML, React, Vue etc).

---

## 📌 Endpoints Principais

### ➕ Criar Aprovado

`POST /aprovados`

**Body (multipart/form-data):**

| Campo     | Tipo   |
| --------- | ------ |
| nome      | String |
| email     | String |
| telefone  | String |
| concursos | String |
| imagem    | File   |

---

### 📄 Listar Aprovados

`GET /aprovados`

---

### 🔍 Buscar Aprovado por ID

`GET /aprovados/{id}`

---

## 🧪 Validações

As validações são feitas utilizando uma estratégia baseada em **Validator Pattern**:

```java
List<ValidatorAprovado> validators;
```

Cada regra de negócio pode ser isolada em uma classe específica, mantendo o código limpo e escalável.

---

## ▶️ Como Rodar o Projeto

### 1️⃣ Pré-requisitos

* Java 21
* Maven
* MySQL
* IDE (IntelliJ, VS Code, Eclipse)

---

### 2️⃣ Clonar o projeto

```bash
git clone https://github.com/Joaomacosdev/portalaprovados.git
```

---

### 3️⃣ Criar o banco (opcional)

```sql
CREATE DATABASE db_portalaprovados;
```

---

### 4️⃣ Rodar a aplicação

```bash
mvn spring-boot:run
```

ou pela classe:

```java
PortalaprovadosApplication.java
```

---

### 5️⃣ Testar

* Backend: `http://localhost:8080`
* Use Postman, Insomnia ou frontend próprio

---

## 🧠 Observações Importantes

* O projeto segue boas práticas de organização e separação de responsabilidades
* Exceptions são centralizadas
* Fácil adaptação para autenticação futura (JWT / OAuth2)
* Estrutura preparada para crescimento

---

## 👨‍💻 Autor

Desenvolvido por **João Marcos**

📱 WhatsApp: **(79) 99637-2827**
📧 E-mail: *joamarcosdev@gmail.com*

---

✅ Projeto desenvolvido para processo seletivo — estruturado, escalável e pronto para produção.
