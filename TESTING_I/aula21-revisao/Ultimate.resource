*** Variables ***
${SITE}         https://ultimateqa.com/simple-html-elements-for-automation/
${NAVEGADOR}    chrome
${BOTAO}        id=idExample
${BOTAO2}       class=buttonClass
${BOTAO3}       name=button1
${BOTAO4}       Click me using this link text!
${GENERO}       gender
${OUTROS}       other
${CHECKBOX}     Bike
${DROPDOWN}     css=#post-909 > div > div.et-l.et-l--post > div > div.et_pb_section.et_pb_section_2.et_section_regular > div > div.et_pb_column.et_pb_column_1_3.et_pb_column_4.et_pb_css_mix_blend_mode_passthrough > div.et_pb_module.et_pb_blurb.et_pb_blurb_8.et_pb_text_align_left.et_pb_blurb_position_top.et_pb_bg_layout_light > div > div > div > select
                # xpath=//*[@id="post-909"]/div/div[1]/div/div[3]/div/div[1]/div[9]/div/div/div/select
${CARRO}        audi

*** Keywords ***
Abrir o site UltimateQA
    Open Browser        ${SITE}      ${NAVEGADOR}
    Maximize Browser Window

Clicar no botão usando "ID"
    Click Element       ${BOTAO}

Clicar no botão usando "ClassName"
    Click Element       ${BOTAO2}

Clicar no botão usando "Name"
    Click Element       ${BOTAO3}

Clicar no botão usando "LinkText"
    Click Link      ${BOTAO4}

Selecionar o radio button "Other"
    #para scrollar a página
    Execute JavaScript      window.scrollTo(0,800)
    #Radio button = group_name + value
    Select Radio Button         ${GENERO}       ${OUTROS}

Selecionar o checkbox "I have a bike"
    Select checkbox     ${CHECKBOX}

Selecionar o item "Audi" do dropdown
    Select From List By Value       ${DROPDOWN}     ${CARRO}
    #Select From List By Index    ${DROPDOWN}    3
