*** Settings ***
Library    SeleniumLibrary
Library    AxeLibrary
*** Variables ***
${SITE}            https://www.amazon.com.br/
${NAVEGADOR}       Chrome

*** Keywords ***
Abrir o site
    Open Browser    ${SITE}    ${NAVEGADOR}
    Maximize Browser Window


Teste de acessibilidade da página principal
    &{results}    Run Accessibility Tests    relatorioAcessibilidade.json
    Log    Contagem de violações: ${results.violations}
    Log Readable Accessibility Result    violations
    Should Be True    ${results.violations} < 10
