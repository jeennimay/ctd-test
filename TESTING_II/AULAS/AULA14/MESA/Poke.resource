*** Variables ***
${HOST}    https://pokeapi.co/api/v2/pokemon-color


*** Keywords ***
Verificação de Pokemons pelo ID da cor
    Verficar cor    red    8

Validação de Status Code da requisição
    Confere status code    200


Verficar cor
    [Arguments]                                  ${COR}    ${ID}
    Create Session    pokeapi    ${HOST}/${ID}
    ${RESPOSTA}=    GET On Session    pokeapi    ${HOST}/${ID}
    Set Test Variable                            ${RESPOSTA}
    Set Test Variable                            ${COR}
    Should Be Equal As Strings                   ${RESPOSTA.json()['name']}    ${COR}
    Log To Console                               \n\nID escolhido: ${ID}
    Log To Console                               Cor escolhida: ${COR}
    Log To Console                               Cor do Pokemon: ${RESPOSTA.json()['name']}\n\n

Confere status code
    [Arguments]                   ${STATUS}
    Should Be Equal As Strings    ${RESPOSTA.status_code}    ${STATUS}
