#Execute Javascript  window.scroll(X,Y) -- para scrollar
#Headless Chrome       -- Rodar sem abrir o Chrome


*** Settings ***
Library    SeleniumLibrary

#Variáveis (Site, navegador, elementos...)...
*** Variables ***
${SITE}                     http://hurb.com/br
${NAVEGADOR}                Chrome
${BOTAO_COOKIES}            xpath=//*[@id="CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"]
${BOTAO_PACOTES}            xpath=//*[@id="__next"]/div[1]/div[2]/div/div/div[1]/div/div/button[2]
${CAMPO_BUSCAR_DESTINO}     xpath=//*[@id="destination-input"]
${DESTINO}                  Buenos Aires
${BOTAO_PESQUISAR}          xpath=//*[@id="__next"]/div[1]/div[2]/div/div/div[2]/button
${PRIMEIRO_RESULTADO}       xpath=//*[@id="__next"]/div/main/section/div[2]/a[1]/div[1]/img


#O passo a passo de cada teste...
*** Keywords ***
Dado que eu estou no site do Hurb
    Open Browser                    ${SITE}    ${NAVEGADOR}
    Maximize Browser Window

Quando eu clico no botão "Permitir todos os Cookies"
    Sleep                     10
    Wait and Click            ${BOTAO_COOKIES}

E busco por um pacote para "Buenos Aires"
    Wait and Click            ${BOTAO_PACOTES}
    Wait and Input Text       ${CAMPO_BUSCAR_DESTINO}    ${DESTINO}
    Wait and Click            ${BOTAO_PESQUISAR}

E seleciono o primeiro pacote dos resultados
    Wait and Click            ${PRIMEIRO_RESULTADO}
    Switch Window             NEW
    Page Should Contain       ${DESTINO}



#Comando "Criados"
Wait and Click
    [Arguments]                      ${ELEMENTO}
    Wait Until Element Is Visible    ${ELEMENTO}
    #Redundancia, mas é válido.
    Wait Until Element Is Enabled    ${ELEMENTO}
    Click Element                    ${ELEMENTO}

Wait and Input Text
    [Arguments]                      ${ELEMENTO}    ${TEXTO}
    Wait Until Element Is Visible    ${ELEMENTO}
    Input Text                       ${ELEMENTO}    ${TEXTO}
