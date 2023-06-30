 # Api mensalidade de futebol
 
## Feito por

* Marlon Gabriel Beraldo Menom
* Victor Monteiro Ribeiro

## Functionalidades

### JOGADORES

#### Listar todos os jogadores
```http request
    GET /jogador/todos
```

#### Criar um jogador
```http request
    POST /jogador
```
 OBS: Para a criação de um novo jogador é necessário passar os parâmetros: `nome`, `email`, `datanasc`
 ( todos sendo do tipo `string` e obrigatórios ).

### PAGAMENTOS

#### Listar todos os pagamentos
```http request
    GET /pagamento
```

### Listar pagamentos por jogador
```http request
    GET /pagamento/{{codJogador}}
```
OBS: `codJogador` sendo do tipo string.

#### Criar um pagamento
```http request
    POST /pagamento
```
OBS: Para a criação de um novo jogador é necessário passar os parâmetros: `ano`, `mes`, `valor`, `codJogador`
( sendo ano, mes e codJogador do tipo `int` e valor do tipo `float`).

