import { limpar } from '../funcionalidad.js'

const id = 'resultado'
const el = document.createElement('span')
el.setAttribute('id', id)
el.innerHTML = '10'
document.body.appendChild(el)

describe('Validar função limpar', () => {
	test ('Limpar', () => {
	const validateElement = document.getElementById(id)
	expect(validateElement.innerHTML).toBe('10')
	limpar();
	expect(validateElement.innerHTML).toBe("")
	})
})
