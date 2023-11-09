#robot -d ./Logs Poke.robot
*** Settings ***
Library     RequestsLibrary
Library     Collections
Resource    ./Poke.resource

*** Test Cases ***
Validação da PokeAPI
    Verificação de Pokemmons por cor
    Validação de Status Code da requisição