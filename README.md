Para rodar o projeto, instale o <code>rabbitMQ</code> via docker:

````
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
````

Crie uma Queue chamada: ***emissao-cartoes***

Instale também o <code>Keycloak</code>:

````
docker run -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.1.1 start-dev
````

em localhost:8081, logue com o usuário e senha ***admin, admin***

crie um novo realm chamado: ***msbanco***

em ***Clients*** crie um novo Client chamando ***user***

Para conseguir o Token você vai no Keycloak em Real settins -> Endpoint -> ***OpenID Endpoint Configuration***.

ao abrir o link, copie o endpoint do ***"token_endpoint":*** e cole no Acess Token URL no postman no OAuth 2.0.

No ***Grant Type***, coloque Client Credentials.

No ***Client ID*** do postman coloque ***user***, o mesmo nome do Client que criamos em cima.

E o Client Secret cole a credencial que está em ***Clients -> Credentials -> Client Secret***
