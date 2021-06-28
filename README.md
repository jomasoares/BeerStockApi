# BeerStockApi

* [Português](#section-1)
* [English](#section-2)

## <a name="section-1"></a> Português (Brasil)

Projeto de API REST com testes unitários desenvolvido no bootcamp Java GFT/DIO.

O objetivo é construir uma API com testes unitários para gerenciamento de estoque de uma cervejaria.
O repositório de referência do bootcamp se encontra [aqui](https://github.com/rpeleias/beer_api_digital_innovation_one).

O projeto foi desenvolvido em Java 11 e possui as seguintes dependências:
* [**Spring Boot Dev tools**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [**Spring Boot Web**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [**Lombok**](https://mvnrepository.com/artifact/org.projectlombok/lombok)
* [**JPA**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
* [**H2**](https://h2database.com/html/main.html)
* [**Mapstruct**](https://mapstruct.org/)
* [**JUnit**](https://junit.org/)
* [**Mockito**](https://site.mockito.org/)
* [**Hamcrest**](http://hamcrest.org/)

## Inicializar o Projeto

Se você já possui o Maven instalado, execute na linha de comando:
```shell script
mvn spring-boot:run 
```
Se não possui, você pode usar o arquivo **mvnw** para a plataforma Linux ou **mvnw.cmd** para Windows, usando o mesmo argumento: **spring-boot:run**. Ambos os arquivos encontram-se na raiz do projeto.

## Objetivo do projeto original

O objetivo do bootcamp é criar uma API REST para gerenciar um estoque de cerveja, utilizando os seguintes *endpoints*:

| *Método HTTP* | *Endpoint*                 | *Ação*                                                          |
| :-----------: |--------------------------- |  -------------------------------------------------------------- |
| GET           | api/v1/beers               | Retorna todos os registros de cervejas                          |
| GET           | api/v1/beers/{name}        | Retorna o registro da cerveja com o nome passado como argumento |
| POST          | api/v1/beers               | Cadastra uma cerveja                                            |
| PATCH         | api/v1/beers/{id}/increment| Adiciona cervejas ao estoque                                    |
| PATCH         | api/v1/beers/{id}/decrement| Remove cervejas do estoque                                      |
| DELETE        | api/v1/beers/{id}          | Deleta o registro de uma cerveja com o id passado como argumento|

## Funcionalidades extras

As seguintes modificações foram feitas em relação ao projeto original:

1. O Stracktrace foi omitido nas mensagens de erro.
3. Uma informação que agreva valor ao produto é saber quais as cervejas que estão com o estoque baixo. por isso foi criado o seguinte *endpoint*:

| *Método HTTP* | *Endpoint*                        | *Ação*                                                                                   |
| :-----------: |---------------------------------- |  --------------------------------------------------------------------------------------- |
| GET           | api/v1/person/stock/below/{limit} | Retorna todos os registros de cervejas com o estoque abaixo do valor informado em *limit*|



## <a name="section-2"></a> English

REST API Project with unit tests from the GFT/DIO Java Bootcamp

The main purpose of this reposity is create an REST API with unit tests to manage a beer stock.
The bootcamp reference repository can be found [here](https://github.com/rpeleias/beer_api_digital_innovation_one).

This project was developed in Java 11. This project uses the following dependencies:
* [**Spring Boot Dev tools**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [**Spring Boot Web**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)
* [**Lombok**](https://mvnrepository.com/artifact/org.projectlombok/lombok)
* [**JPA**](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)
* [**H2**](https://h2database.com/html/main.html)
* [**Mapstruct**](https://mapstruct.org/)
* [**JUnit**](https://junit.org/)
* [**Mockito**](https://site.mockito.org/)
* [**Hamcrest**](http://hamcrest.org/)

## Getting Started

If you have Maven installed, run ***mvn spring-boot:run*** in the command line:
```shell script
mvn spring-boot:run 
```
If you don't, you can use the **mvnw** file for Linux or **mvnw.cmd** for Windows and the same argument: **spring-boot:run**. Both files can be found in the root directory.

## Original project goal

The bootcamp goal is create an REST API to manage a beer stock, using the following endpoints:

| *HTTP Method* | *Endpoint*                 | *Action*                             |
| :-----------: |--------------------------- |  ----------------------------------- |
| GET           | api/v1/beers               | Return all beer entries              |
| GET           | api/v1/beers/{name}        | Return a beer entry, using the name  |
| POST          | api/v1/beers               | Register a new beer                  |
| PATCH         | api/v1/beers/{id}/increment| Increment the beer stock             |
| PATCH         | api/v1/beers/{id}/decrement| Decrement the beer stock             |
| DELETE        | api/v1/beers/{id}          | Delete a beer entry, using the id    |

## Extra functionalities

The following modifications were added to the origianl project:

1. Stracktrace is ommited from error mensages.
3. Knowing wich beer stocks are running low is an import information for the user. So the following endpoint was added:

| *HTTP Method* | *Endpoint*                        | *Action*                                 |
| :-----------: |---------------------------------- |  --------------------------------------- |
| GET           | api/v1/person/stock/below/{limit} | Return all beer stocks bellow the *limit*|
