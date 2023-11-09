*** Variables ***
${SITE}                     https://www.hurb.com/br
${BROWSER}                  chrome
${BOTAOCOOKIES}             id=CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll
${BOTAOPACOTE}              css=#__next > div.Header_Header__1jiZz > div.hrc-2LOsj > div > div > div.h-91nvuq > div > button:nth-child(2)
${INPUTVAIPRAONDE}          id=downshift-1-input
${BOTAOPESQUISAR}           css=#__next > div.Header_Header__1jiZz > div.hrc-2LOsj > div > div > div.hrc-2_yd0.hrc-3T0_Y > button
${PACOTEVIAGEM}             css=#__next > div > main > div.ResultsCardsContainer_ResultsCardContainer__1jtiB > a:nth-child(4) > div.hrc-3-0W1 > img
${BOTAOESCOLHEROPCAO}       css=body > div:nth-child(4) > section > div.box-offer-top.box-nopadding.col-sm-6.col-md-6 > div > section.box-offer-main.pull-left > div:nth-child(5) > div.pull-left.first-box > button
${BOTAOCOMPRAR}             //*[@id="offer-options"]/div[2]/div[1]/div[2]/div[2]/div/div[4]/div[2]/div[4]/a
${CONFIGURACAOVIAGEM}       css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(7) > div > div > div:nth-child(2) > div.col-xs-8.col-sm-8.col-md-8.text-right
${PERIODOINICIAL}           css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(9) > div > div > div:nth-child(2) > div.col-xs-7.col-sm-7.col-md-7.text-right.booking-info__date-formatted.summary-highlight
${PERIODOFINAL}             css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(9) > div > div > div:nth-child(3) > div.col-xs-7.col-sm-7.col-md-7.text-right.booking-info__date-formatted.summary-highlight
${BOLETOPARCELADO}          id=ui-id-1
${INPUTEMAIL}               id=itxEmail
${INPUTNOME}                css=#paymentMethods__bill > section > div:nth-child(2) > div:nth-child(1) > div > input
${INPUTCPF}                 css=#paymentMethods__bill > section > div:nth-child(2) > div:nth-child(2) > div > input
${INPUTCELULAR}             css=#paymentMethods__bill > section > div:nth-child(2) > div:nth-child(3) > div > input
${INPUTNUMEROSPARCELA}      id=select2-installments[]-2l-container
${CHECKBOXPOLTICA}          id=cancellation-policy
${CANCELAMENTOGRATIS}       css=#purchase-confirmation > div:nth-child(1) > div > div > div.free-cancellation-policy__message


*** Keywords ***
Abrir o site do Hurb
    Open Browser        ${SITE}     ${BROWSER}
    Maximize Browser Window
    #Set Selenium Speed      0.25

Clicar em "Permitir todos os cookies"
    Sleep       10
    Click Element       ${BOTAOCOOKIES}

Selecionar a opção "Pacotes"
    Wait Until Element is Visible       ${BOTAOPACOTE}       35
    Click Element       ${BOTAOPACOTE}

Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
    Input Text          ${INPUTVAIPRAONDE}     salvador
    Click Element       ${BOTAOPESQUISAR}

Selecionar um pacote de viagem
    Click Element       ${PACOTEVIAGEM}

Clicar em "ESCOLHER OPÇÃO"
    Switch Window       NEW
    Wait Until Element is Visible       ${BOTAOESCOLHEROPCAO}       15
    Click Element       ${BOTAOESCOLHEROPCAO}

Escolher uma opção de viagem e clicar em "COMPRAR"
    Wait Until Element is Visible       ${BOTAOCOMPRAR}       20
    Click Element       ${BOTAOCOMPRAR}

Validar as informações da "Configuração" da viagem
    Wait Until Element is Visible       ${CONFIGURACAOVIAGEM}       10
    Element Should Contain      ${CONFIGURACAOVIAGEM}     4 Noites\n1 pessoa por pacote

Validar as informações do período da viagem
    Wait Until Element is Visible       ${PERIODOINICIAL}       10
    Element Should Contain      ${PERIODOINICIAL}     01 Ago 2022
    Element Should Contain      ${PERIODOFINAL}     30 Nov 2022


Selecionar a opção "Boleto parcelado"
    Click Element       ${BOLETOPARCELADO}

Preencher os dados de pagamento
    #Execute JavaScript  window.scrollTo(0,800)
    Input Text          ${INPUTEMAIL}      email@email.com
    Input Text          ${INPUTNOME}       Jennifer Mayumi
    Input Text          ${INPUTCPF}        85767819807
    Input Text          ${INPUTCELULAR}    1199999999

Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"
    Select Checkbox     ${CHECKBOXPOLTICA}

Validar a informação sobre cancelamento grátis
    Element Should Contain      ${CANCELAMENTOGRATIS}      Cancelamento Grátis! 
    Capture Page Screenshot
