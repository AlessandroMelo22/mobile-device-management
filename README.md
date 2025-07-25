# 📱 Sistema de Gerenciamento de Dispositivos Móveis (MDM)

Este projeto é um sistema web RESTful desenvolvido com **Java** e **Spring Boot**, com foco em auxiliar empresas a realizarem o **controle e gerenciamento de dispositivos móveis corporativos**, bem como a organização de usuários e departamentos.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Web (REST)
- Spring Data JPA
- Hibernate
- PostgreSQL
- Hibernate Validator
- Spring AOP

---

## ⚙️ Funcionalidades Implementadas

- ✅ Camadas bem definidas: Controller, Service, Repository, DTO, Exception, Mapper
- ✅ Cadastro, listagem, atualização e exclusão de **usuários**
- ✅ Criação e gerenciamento de **departamentos**
- ✅ Registro e controle de **dispositivos móveis**
- ✅ Separação entre entidades e **DTOs**
- ✅ Criação de **exceptions personalizadas** para regras de negócio
- ✅ Tratamento global de exceções com `@RestControllerAdvice`
- ✅ **Validação** de dados com Hibernate Validator

---

## 🧱 Estrutura do Projeto

```java
src/
└── main/
      └── java/
            └── com.alessandromelo/
                      ├── controller/  //Endpoints REST
                      ├── dto/  //Objetos de transferência de dados
                      ├── entity/  //Entidades JPA
                      ├── enums/ 
                      ├── exceptions/  //Exceptions personalizadas
                      ├── exceptionhandler/  //Tratamento global de exceções
                      ├── mapper/  //Conversão manual entre entidades e DTOs
                      ├── repository/  //Interface com o banco de dados
                      └── service/  //Regras de negócio
```

---

## ▶️ Como Executar Localmente

### Pré-requisitos:
- Java 21
- PostgreSQL
- Maven

### Passos:

1. Clone o repositório:
```bash
git clone https://github.com/AlessandroMelo22/mobile-device-management.git
```
2. Configure as credenciais do banco no `application.properties` ou `application.yml`.

3. Execute a aplicação:
```
./mvnw spring-boot:run
```
Acesse:
```
http://localhost:8080
```
## 📌 Status do Projeto
**🚧 Em evolução contínua**  
O sistema já está funcional e com boa cobertura das funcionalidades principais. Próximas etapas previstas:

- Novas operações envolvendo os Dispositivos
- Logs utilizando Spring AOP 
- Testes automatizados
- Documentação com Swagger


## 🤝 Contribuições
Sinta-se à vontade para abrir issues ou sugestões. Toda contribuição é bem-vinda!


## 👤 Autor
Desenvolvido por [Alessandro Melo](https://github.com/AlessandroMelo22)   
🔗 [LinkedIn](https://www.linkedin.com/in/alessandro-melo-dev/)


## 📝 Licença
Este projeto está licenciado sob a MIT License.
