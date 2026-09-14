import LoginPage from '../pages/LoginPage'

describe('Login', () => {

    it('Deve realizar login com sucesso', () => {
        LoginPage.acessar()
        LoginPage.realizarLogin('standard_user', 'secret_sauce')

        cy.url().should('include', '/inventory.html')
        cy.get('.title').should('have.text', 'Products')
    })

})