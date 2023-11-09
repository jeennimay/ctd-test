# library - https://robotframework.org/Selenium2Library/Selenium2Library.html
#robot -d ./Logs Ultimate.robot         (para por os arquivos na pasta log)
#robot -t "Teste 01" Ultimate.robot     (para rodar um único arquivo)
#robot -t "Teste 01" -t "Teste 02" Ultimate.robot (para rodar mais de um teste específico)
#robot -v CARRO:saab Ultimate.robot     (para redeclarar a variável)
#robot -d ./Logs -v CARRO:saab -t "Teste 01" Ultimate.robot


*** Settings ***
Library         SeleniumLibrary
Test Setup      Abrir o site UltimateQA
Test Teardown   Close Browser
Resource        ./Ultimate.resource


*** Test Cases ***
Teste 01
    Clicar no botão usando "ID"

Teste 02
    Clicar no botão usando "ClassName"

Teste 03
    Clicar no botão usando "Name"

Teste 04
    Clicar no botão usando "LinkText"

Teste 05
    Selecionar o radio button "Other"

Teste 06
    Selecionar o checkbox "I have a bike"

Teste 07
    Selecionar o item "Audi" do dropdown
