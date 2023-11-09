#Jennifer Mayumi Koga
#robot -d ./Logs Hurb.robot

*** Settings ***
Library         SeleniumLibrary
Test Setup      Abrir o site do Hurb
Test Teardown   Close Browser
Resource        ./Hurb.resource


*** Test Cases ***
Processo de reserva de pacote de viagens
    Clicar em "Permitir todos os cookies"
    Selecionar a opção "Pacotes"
    Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
    Selecionar um pacote de viagem
    Clicar em "ESCOLHER OPÇÃO"
    Escolher uma opção de viagem e clicar em "COMPRAR"
    Validar as informações da "Configuração" da viagem
    Validar as informações do período da viagem
    Selecionar a opção "Boleto parcelado"
    Preencher os dados de pagamento
    Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"
    Validar a informação sobre cancelamento grátis


