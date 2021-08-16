# user-management

## Sobre

Simples API para cadastro de usuários feita na linguagem java utilizando spring, com o banco de dados h2 e com deploy feito através do heroku.

## Swagger

A fim de facilitar o uso dessa API localmente, sintam-se a vontade para utilizarem o swagger.

Link para localhost: http://localhost:8080/swagger-ui.html#/

## Endpoints

Atualmente possuímos 5 endpoints, sendo eles:

- Criar novo usuário: https://usermanagementchallenge.herokuapp.com/user/create

- Buscar todos os usuários: http://usermanagementchallenge.herokuapp.com/user/findAll

- Buscar um usuário por id: https://usermanagementchallenge.herokuapp.com/user/<número_do_id>

- Deletar um usuário por id: https://usermanagementchallenge.herokuapp.com/user/<número_do_id>

- Autenticar um usuário: https://usermanagementchallenge.herokuapp.com/user/auth


## Criar usuário

Criar usuário é uma http request do tipo POST onde o corpo da requisição deverá conter os campos de usuário e a resposta será os dados desse mesmo usuário com exceção da senha.

Esse endpoint não necessita de autenticação.

## Buscar todos os usuários

Buscar todos os usuários é uma http request do tipo GET que tratá um vetor com todos os usuários cadastrados em banco.

Esse endpoint não necessita de autenticação.

## Buscar um usuário por id

Buscar um usuário por id é uma http request do tipo GET que trará o usuário no qual o id será colocado na url.

## Deletar um usuário por id

Deletar um usuário por id é uma http request do tipo DELETE que irá deletar o usuário no qual o id será colocado na url.

## Autenticar um usuário

Autenticar um usuário é uma http request do tipo POST onde o corpo da requisição deverá conter os campos de email e senha de um usuário cadastrado e o retorno é o 
token que deverá ser utilizado para a autenticação do usuário.

Esse endpoint não necessita de autenticação

## Como utilizar o token

Por não possuir um frontend, indicamos o uso de alguma ferramenta para testar seus endpoints, tal como o postman, por exemplo. Ao utilizarmos o  endpoint /auth e obtermos 
sucesso na autenticação, receberemos uma resposta json do tipo "token": "{valor_do_token}". 

Esse valor_do_token deverá ser copiado e colocado no header da requisição que será feita com a key: "Authorization" e o value: "Bearer <valor_do_token>". Todas as requisições
que necessitarem de autenticação precisam ter esse valor em seus headers. O token expirará em 30 minutos após sua construção.


  
