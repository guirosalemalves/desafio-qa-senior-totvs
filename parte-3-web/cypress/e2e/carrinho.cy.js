import LoginPage from '../pages/LoginPage'

describe('Carrinho', () => {

    beforeEach(() => {
        LoginPage.acessar()
        LoginPage.realizarLogin('standard_user', 'secret_sauce')
    })

    it('Deve adicionar dois produtos ao carrinho', () => {
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()
        cy.get('[data-test="add-to-cart-sauce-labs-bike-light"]').click()
        cy.get('.shopping_cart_badge').should('have.text', '2')
    })

})