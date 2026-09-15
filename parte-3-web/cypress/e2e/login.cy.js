import LoginPage from '../pages/LoginPage'

describe('Login', () => {

    it('Deve realizar login com sucesso', () => {
        LoginPage.acessar()
        LoginPage.realizarLogin('standard_user', 'secret_sauce')
        LoginPage.validarLoginComSucesso()
    })
})