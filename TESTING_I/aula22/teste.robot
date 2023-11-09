#Open Browser | Close Browser | Wait Until Element is Visible | Sleep | Click Element | Input Text | Element Should Contain | Maximize Browser Window

*** Settings ***
Library             SeleniumLibrary
Test Setup          Abrir o site da loja
Test Teardown       Close Browser
Resource            ./Keywords.robot            #pode nomear o arquivo como " .resource " que funciona também

*** Test Case ***
[Teste 00 - finlizando uma compra com usuário comum durante a aula]
        Fazer login no site da loja
        Abrir os detalhes do produto "Sauce Labs Bolt T-Shirt"
        Adicionar o produto "Sauce Labs Bolt T-Shirt" ao carrinho
        Abrir o carrinho de compras
        Clicar em "CHECKOUT"
        Preencher as informações do cliente e clicar em "CONTINUE"
        Confirmar se o valor final da compra é de $17.27 e clica no botão "FINISH"
        Verificar se a frase "THANK YOU FOR YOUR ORDER" está sendo exibida
