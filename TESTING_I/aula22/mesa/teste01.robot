##Jennifer Mayumi

*** Settings ***
Library             SeleniumLibrary
#Test Setup          Abrir o site da loja
#Test Teardown       Close Browser

*** Variables ***
#${DRIVER}                           C:\\Python39\\Scripts
${SITE}                             https://www.saucedemo.com
${BROWSER}                          chrome
${LOGIN}                            id=user-name
${SENHA}                            id=password
${BOTAOLOGIN}                       id=login-button
${DETALHES_SAUCELABSPACK}           css=#item_4_title_link > div
${ADICIONAR_SAUCELABSPACK}          id=add-to-cart-sauce-labs-backpack
${CARRINHO}                         css=#shopping_cart_container > a
${REMOVER_SAUCELABSPACK}            id=remove-sauce-labs-backpack
${CONTINUESHOPPING}                 id=continue-shopping
${ADICIONAR_FLEECEJACKET}           id=add-to-cart-sauce-labs-fleece-jacket
${CHECKOUT}                         id=checkout
${FIRSTNAME}                        id=first-name
${LASTNAME}                         id=last-name
${POSTALCODE}                       id=postal-code
${BOTAOCONTINUE}                    id=continue
${VALORTOTAL}                       css=#checkout_summary_container > div > div.summary_info > div.summary_total_label
${BOTAOFINISH}                      id=finish
${THANKYOU}                         css=#checkout_complete_container > h2

*** Test Case ***
[TESTE 01 - Finalizando uma compra com usuário comum]
        Fazer login no site com o usuário "standard_user".
        Acessar os detalhes do produto "Sauce Labs Backpack".
        Adicionar o produto "Sauce Labs Backpack" ao carrinho de compras.
        Abrir o carrinho de compras.
        Remover o produto "Sauce Labs Backpack" do carrinho de compras.
        Clicar em "Continue Shopping" para voltar à Página Inicial.
        Adicionar o produto "Sauce Labs Fleece Jacket" ao carrinho de compras.
        Abrir o carrinho de compras.
        Clicar em "Checkout" para finalizar a compra.
        Preencher os dados: PRIMEIRO NOME (FIRST NAME), SOBRENOME (LAST NAME) E CEP (POSTAL CODE).
        Clicar no botão "CONTINUE".
        Validar se o valor total cobrado é de "$53.99".
        Clicar no botão "FINISH".
        Validar que a compra foi realizada e a mensagem "THANK YOU FOR YOUR ORDER" está sendo exibida

*** Keywords ***
Fazer login no site com o usuário "standard_user".
    Open Browser        ${SITE}         ${BROWSER}          #executable_path=${DRIVER}
    Input Text          ${LOGIN}        standard_user
    Input Text          ${SENHA}        secret_sauce
    Click Element       ${BOTAOLOGIN}

Acessar os detalhes do produto "Sauce Labs Backpack".
    Wait Until Element is Visible       ${DETALHES_SAUCELABSPACK}           10
    Click Element       ${DETALHES_SAUCELABSPACK}

Adicionar o produto "Sauce Labs Backpack" ao carrinho de compras.
    Click Element       ${ADICIONAR_SAUCELABSPACK}

Abrir o carrinho de compras.
    Click Element       ${CARRINHO}

Remover o produto "Sauce Labs Backpack" do carrinho de compras.
    Wait Until Element is Visible       ${REMOVER_SAUCELABSPACK}
    Click Element       ${REMOVER_SAUCELABSPACK}

Clicar em "Continue Shopping" para voltar à Página Inicial.
    Click Element       ${CONTINUESHOPPING}

Adicionar o produto "Sauce Labs Fleece Jacket" ao carrinho de compras.
    Click Element       ${ADICIONAR_FLEECEJACKET}

Clicar em "Checkout" para finalizar a compra.
    Click Element       ${CHECKOUT}

Preencher os dados: PRIMEIRO NOME (FIRST NAME), SOBRENOME (LAST NAME) E CEP (POSTAL CODE).
    Input Text      ${FIRSTNAME}        Jennifer
    Input Text      ${LASTNAME}         Mayumi
    Input Text      ${POSTALCODE}       00000000

Clicar no botão "CONTINUE".
    Click Element       ${BOTAOCONTINUE}

Validar se o valor total cobrado é de "$53.99".
    Wait Until Element is Visible       ${VALORTOTAL}
    Element Should Contain      ${VALORTOTAL}       $53.99

Clicar no botão "FINISH".
    Click Element       ${BOTAOFINISH}

Validar que a compra foi realizada e a mensagem "THANK YOU FOR YOUR ORDER" está sendo exibida
    Wait Until Element is Visible       ${THANKYOU}
    Element Should Contain      ${THANKYOU}     THANK YOU FOR YOUR ORDER
    Sleep       5
    Capture Page Screenshot