import LoginPage from '../pages/LoginPage'
import CartPage from '../pages/CartPage'

describe('Carrinho', () => {

    beforeEach(() => {
        LoginPage.acessar()
        LoginPage.realizarLogin('standard_user', 'secret_sauce')
    })

    it('Deve adicionar dois produtos ao carrinho', () => {
        CartPage.adicionarProdutos()
        CartPage.validarQuantidadeCarrinho(2)
    
    cy.screenshot('../../evidencias/02-produtos-carrinho')
    })
})