#*Settings - já funciona
*** Settings ***
Resource     ./Variables.robot

*** Keywords ***
Abrir o site da loja
    Open Browser        ${URL}      ${NAVEGADOR}        #executable_path=${DRIVER}

Fazer login no site da loja
    Wait Until Element is Visible       ${LOGIN}       10
    Input Text      ${LOGIN}        standard_user
    Input Text      ${SENHA}        secret_sauce
    Click Element   ${BOTAOLOGIN}
    #Capture Page Screenshot

Abrir os detalhes do produto "Sauce Labs Bolt T-Shirt"
    Wait Until Element is Visible       ${BOLT}       10
    Click Element   ${BOLT}

Adicionar o produto "Sauce Labs Bolt T-Shirt" ao carrinho
    Wait Until Element is Visible       ${ADICIONARBOLT}       10
    Click Element       ${ADICIONARBOLT}

Abrir o carrinho de compras
    Wait Until Element is Visible       ${CARRINHO}       10
    Click Element       ${CARRINHO}

Clicar em "CHECKOUT"
    Wait Until Element is Visible       ${CHECKOUT}       10
    Click Element       ${CHECKOUT}

Preencher as informações do cliente e clicar em "CONTINUE"
    Wait Until Element is Visible       ${FIRSTNAME}       10
    Input Text      ${FIRSTNAME}        Jennifer
    Input Text      ${LASTNAME}         Mayumi
    Input Text      ${POSTALCODE}       00000000
    Click Element   ${CONTINUE}

Confirmar se o valor final da compra é de $17.27 e clica no botão "FINISH"
    Element Should Contain      ${VALORFINAL}       $17.27
    Click Element       ${FINISH}

Verificar se a frase "THANK YOU FOR YOUR ORDER" está sendo exibida
    Element Should Contain      ${THANKYOU}     THANK YOU FOR YOUR ORDER
    Sleep       5
    Capture Page Screenshot

