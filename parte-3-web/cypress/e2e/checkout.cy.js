import LoginPage from '../pages/LoginPage'
import CartPage from '../pages/CartPage'
import CheckoutPage from '../pages/CheckoutPage'

describe('Checkout', () => {

    beforeEach(() => {
        LoginPage.acessar()
        LoginPage.realizarLogin('standard_user', 'secret_sauce')
    })

    it('Deve realizar checkout com sucesso', () => {

        CartPage.adicionarProdutos()
        CartPage.validarQuantidadeCarrinho(2)
        CartPage.acessarCarrinho()
        CartPage.iniciarCheckout()

        CheckoutPage.preencherDados('Guilherme', 'Alves', '09700-000')
        CheckoutPage.continuar()
        CheckoutPage.finalizarCompra()
        CheckoutPage.validarCompraFinalizada()

        cy.screenshot('../../evidencias/03-checkout-finalizado')
    })

})