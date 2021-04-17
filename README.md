# Discord Bot

[![Docker Image CI](https://github.com/jonathanmdr/bot-discord/actions/workflows/docker-image.yml/badge.svg?branch=master)](https://github.com/jonathanmdr/bot-discord/actions/workflows/docker-image.yml)

Obot  é um bot para o aplicativo Discord desenvolvido em Java que calcula seu IMC.

## Configuração

### Executando com Docker:
```
~$ docker run -d -p 80:80 -name obot jonathanmdr/obot:latest
```
> :warning: É necessário ter configurado a variável de ambiente `TOKEN` do bot com um valor válido atribuído.

#### Configurando o Token:
```
~$ export TOKEN="Asdfg123Gfdsa321"
```

### Executando com Kubernetes:
```
~$ kubectl apply -f ./kubernetes/deployment.yaml -f ./kubernetes/service.yaml
```
> :warning: É necessário ter configurado uma `secret` de nome `obot-secret` com a chave `TOKEN` com um valor válido atribuído.

#### Configurando secret:
```
~$ kubectl create secret generic obot-secret --from-literal=TOKEN=Asdfg123Gfdsa321
```

## Utilizando o bot:

Para utilizar basta enviar uma mensagem conforme abaixo:
> Padrão: `!imc {nome} {altura} {peso}` \
> Exemplo: `!imc Jonathan 1.75 80`