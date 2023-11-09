#robot -d ./Logs Hurb.robot

#condições
*** Settings ***
Library          SeleniumLibrary
Resource         ./Hurb.resource
Test Teardown    Close Browser

#Títulos dos testes
*** Test Cases ***
Processo de compra de um pacote de viagem
    Dado que eu estou no site do Hurb
    Quando eu clico no botão "Permitir todos os Cookies"
    E busco por um pacote para "Buenos Aires"
    E seleciono o primeiro pacote dos resultados