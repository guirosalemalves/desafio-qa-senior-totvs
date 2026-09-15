class LoginPage {

    acessar() {
        cy.visit('https://www.saucedemo.com/')
    }

    realizarLogin(usuario, senha) {
        cy.get('[data-test="username"]').type(usuario)
        cy.get('[data-test="password"]').type(senha)
        cy.get('[data-test="login-button"]').click()
    }
    validarLoginComSucesso() {
    cy.url().should('include', '/inventory.html')
    cy.get('.title').should('have.text', 'Products')
    }
}

export default new LoginPage()