#robot -d ./Logs Poke.robot
*** Settings ***
Library     RequestsLibrary
Library     Collections
Resource    ./Poke.resource

*** Test Cases ***
Validação da PokeAPI
    Verificação de Pokemons pelo ID da cor
    Validação de Status Code da requisição