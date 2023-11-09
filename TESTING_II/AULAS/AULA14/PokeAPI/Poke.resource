#*** Settings ***
#Library    RequestsLibrary

*** Variables ***
${HOST}    https://pokeapi.co/api/v2/pokemon-color


*** Keywords ***
Verificação de Pokemmons por cor
    Verficar cor    red

Validação de Status Code da requisição
    Confere status code    200




#Log    ....     -- imprime
Verficar cor
    [Arguments]                                  ${COR}
    Create Session    pokeapi    ${HOST}/${COR}
    ${RESPOSTA}=    GET On Session    pokeapi    ${HOST}/${COR}
    #Set Test Variable = parametro global
    Set Test Variable                            ${RESPOSTA}
    Set Test Variable                            ${COR}

Confere status code
    [Arguments]                   ${STATUS}
#    Set Test Variable             ${RESPOSTA}
    Should Be Equal As Strings    ${RESPOSTA.status_code}    ${STATUS}
