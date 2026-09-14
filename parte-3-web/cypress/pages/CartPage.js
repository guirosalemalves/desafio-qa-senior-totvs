class CartPage {

    adicionarProdutos() {
        cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click()
        cy.get('[data-test="add-to-cart-sauce-labs-bike-light"]').click()
    }

    validarQuantidadeCarrinho(quantidade) {
        cy.get('.shopping_cart_badge')
            .should('have.text', quantidade.toString())
    }

    acessarCarrinho() {
        cy.get('[data-test="shopping-cart-link"]').click()
    }

    iniciarCheckout() {
        cy.get('[data-test="checkout"]').click()
    }
}

export default new CartPage()