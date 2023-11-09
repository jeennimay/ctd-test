#robot -d ./Logs

*** Settings ***
Library          SeleniumLibrary
Library          AxeLibrary
Resource         ./GTD.resource
Test Setup       Abrir o site
Test Teardown    Close Browser


*** Test Cases ***
Teste de Acessibiliade
    Teste de acessibilidade da página principal
