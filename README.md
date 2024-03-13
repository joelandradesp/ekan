![Logotipo.](/imagens/logo.jpg "Logo.") 
# Avaliação - Desenvolvedor Backend Java 

Considerando o seguinte diagrama de classes:
![Modelo de Dados.](/imagens/modelodados.jpg "Modelo de Dados.") 

Crie uma aplicação utilizando Java e Spring Boot que forneça uma API REST para manter o cadastro de beneficiários de um plano de saúde.


Devem ser expostos endpoints para executar as seguintes operações:

* Cadastrar um beneficiário junto com seus documentos;
* Listar todos os beneficiários cadastrados;
* Listar todos os documentos de um beneficiário a partir de seu id;
* Atualizar os dados cadastrais de um beneficiário;
* Remover um beneficiário.


Instruções:
* O prazo para a conclusão é de 3 dias contados a partir da data de recebimento deste teste;
* Os dados devem ser salvos em um banco de dados relacional de sua escolha, podendo este ser um banco de dados embarcado, como H2 ou Derby;
* É necessário autenticação/autorização para acesso aos endpoints;
* Fornecer a documentação dos endpoints utilizando Swagger;
* Após a conclusão commitar o código em um repositório no GitHub e enviar o link para pdantas@ekan.com.br;
* No repositório, criar um arquivo readme.md explicando como a aplicação foi desenvolvida e as instruções para executar o build.

## Desenvolvimento do Projeto

1. Foi criado o projeto no editor STS - Spring Tool Suite. Esse editor já tem integrado o Spring Initilizer. (https://start.spring.io/)
2. Escolhi as dependências Spring Web, Spring Security, H2 Database. Como versão do Java, escolhi o Java 17.
3. Já encontrei um problema com o componenente springfox para ser utilizado no Swagger. Spring Fox foi descontinuado e terei que usar o SpringDoc.
Aqui é um grande problema que temos no Java, componentes que não foram migrados. Por conta disso as empresas continuam utilizando versões antigas do Java.


## Swagger

![Swagger.](/imagens/Swagger.jpg "Swagger.") 


## Postman

![Postman Cadastrar.](/imagens/postman-cadastrar.jpg "Postman Cadastrar.") 

## Endpoints:

Swagger: http://localhost:8080/swagger-ui/index.html#

Health Check Actuator: http://localhost:8080/actuator/health

Health Check: http://localhost:8080/health/ready

Health Check: http://localhost:8080/health/ready

Cadastrar beneficiário e documentos: http://localhost:8080/api/beneficiarios/cadastrar

Payload:

```
{
    "nome":"Joel Alexandre",
    "telefone": "11982429536",
    "dataNascimento":"1977-01-22",
    "dataAtualizacao":"2024-03-12",
    "dataInclusao":"2024-03-12",
     "documentos":[
         {
         "tipoDocumento":"RG",
         "descricao": "RG",
         "dataInclusao":"2024-03-12",
         "dataAtualizacao":"2024-03-12"
       },
        {
         "tipoDocumento":"CPF",
         "descricao": "CPF",
         "dataInclusao":"2024-03-12",
         "dataAtualizacao":"2024-03-12"
       }
       ]
}

```

Atualizar beneficiário e documentos: http://localhost:8080/api/beneficiarios/1

```
{  
    "id":"1",
    "nome":"Joel Alexandre Alexandre",
    "telefone": "11982429536",
    "dataNascimento":"1977-01-22",
    "dataAtualizacao":"2024-03-12",
    "dataInclusao":"2024-03-12",
     "documentos":[
         {
         "tipoDocumento":"RG",
         "descricao": "RG",
         "dataInclusao":"2024-03-12",
         "dataAtualizacao":"2024-03-12"
       },
        {
         "tipoDocumento":"CPF",
         "descricao": "CPF",
         "dataInclusao":"2024-03-12",
         "dataAtualizacao":"2024-03-12"
       }
       ]
}

```

Deletar beneficiario e documentos: http://localhost:8080/api/beneficiarios/1