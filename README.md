# 🚀 Answer42 API – NASA Exoplanets + Spring Batch

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![Spring Batch](https://img.shields.io/badge/Spring_Batch-ETL-blue?style=for-the-badge&logo=spring)
![MongoDB](https://img.shields.io/badge/MongoDB-NoSQL-47A248?style=for-the-badge&logo=mongodb)
![OpenAPI](https://img.shields.io/badge/Swagger-OpenAPI_3-85EA2D?style=for-the-badge&logo=openapi-initiative)

API backend robusta desenvolvida com **Java 21**, **Spring Boot 3** e **Spring Batch**, projetada para consumir, processar e expor dados reais da **NASA Exoplanet Archive**. O projeto foca em engenharia de dados, agregações complexas em NoSQL e princípios avançados de design de API REST.

> 🌌 "A resposta para a vida, o universo e tudo mais... agora em formato JSON."

---

## 🎯 Objetivo do Projeto

* **Ingestão de Dados em Massa**: Consumo do dataset oficial da NASA via jobs de **Spring Batch**.
* **Processamento ETL**: Limpeza e transformação de registros brutos em documentos otimizados para consulta.
* **Persistência Escalável**: Armazenamento de mais de 4.500 registros de exoplanetas em **MongoDB**.
* **Filtros Científicos**: Endpoints inteligentes para identificação de planetas por habitabilidade e características estelares.
* **HATEOAS**: Navegação entre recursos seguindo o nível 3 de maturidade REST.

---

## 🧠 Principais Decisões Técnicas

* **Pipeline de Dados (Spring Batch)**: Implementação de `ItemReader`, `ItemProcessor` e `ItemWriter` para garantir resiliência e performance na ingestão assíncrona.
* **MongoDB Aggregations**: Uso avançado de `Aggregation.group()` e `Aggregation.match()` para realizar cálculos de sistemas solares diretamente na camada de banco de dados.
* **Tratamento Global de Exceções**: Arquitetura baseada em `@ControllerAdvice` e `StandardError` para garantir respostas padronizadas e limpas.
* **Documentação OpenAPI**: Contrato de API detalhado via **Swagger**, com descrições técnicas de atributos astronômicos e exemplos reais.

---

## 🔭 Domínio do Projeto (Endpoints Principais)

* **`/exoplanets`**: Listagem paginada de todos os exoplanetas com informações básicas.
* **`/exoplanets/earth-similar`**: Filtro para planetas com características similares à Terra (Raio, Massa e Temperatura).
* **`/exoplanets/top-stars`**: Agregação das estrelas com maior número de planetas orbitantes.
* **`/exoplanets/big-stars`**: Listagem de sistemas planetários em estrelas de grande raio estelar.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: Java 21
* **Framework**: Spring Boot 3.x (Spring Data MongoDB, Spring Batch, Spring HATEOAS)
* **Banco de Dados**: MongoDB
* **Documentação**: OpenAPI 3 / Swagger
* **Testes**: JUnit 5, Mockito

---

## ⚙️ Como Executar o Projeto
 **Clonar o repositório**:
   ```bash
   git clone [https://github.com/Joao-Victor-Teixeira/answer42-exoplanets](https://github.com/Joao-Victor-Teixeira/answer42-exoplanets) 

   Configurar o MongoDB: Certifique-se de que o MongoDB está ativo (localmente ou via Docker) na porta padrão 27017.

    Rodar a Aplicação:

    ./mvnw spring-boot:run
    Acessar a Documentação: Acesse http://localhost:8082/swagger-ui.html para explorar os endpoints.
   ```
🛡️ Desenvolvedor
João Victor Teixeira 📍 Barbacena, MG
