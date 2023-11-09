from selenium import webdriver

driver = webdriver.Chrome()
driver.get('http://mercadolivre.com.br')

""" DRIVER.FIND_ELEMENT_BY_CSS_SELECTOR (CAMINHO PEGO DO SITE EM COPIAR SELETOR) """
CAMPO_BUSCA = driver.find_element_by_css_selector("body > header > div > form > input").send_keys("Baralho Uno")

""" CLICK NA LUPA """
LUPA = driver.find_element_by_css_selector("body > header > div > form > button").click()

PRIMEIRO_RESULTADO = driver.find_element_by_css_selector("#root-app > div > div.ui-search-main.ui-search-main--exhibitor.ui-search-main--only-products > section > ol:nth-child(2) > li:nth-child(1) > div > div > div.ui-search-result__image > a > div > div > div.slick-list > div > div.slick-slide.slick-active > img").click()

ACEITAR_COOKIES = driver.find_element_by_css_selector("#newCookieDisclaimerButton").click()

ADCIONAR_CARRINHO = driver.find_element_by_css_selector("#root-app > div > div.ui-pdp-container.ui-pdp-container--pdp > div > div.ui-pdp-container__col.col-1.ui-pdp-container--column-right.mt-16.pr-16.ui-pdp--relative > div > div.ui-pdp-container__row.ui-pdp-component-list.pr-16.pl-16 > div > div.ui-pdp-container__row.ui-pdp-container__row--main-actions > form > div > button.andes-button.andes-button--loud").click()



""" IMPRIMIR QUE O TESTE PASSOU """
print("PASS")

""" driver.quit() """
