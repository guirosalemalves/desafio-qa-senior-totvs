package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class ProductTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

    private static int criarProduto(String titulo, double preco) {

        String body = """
                {
                  "title": "%s",
                  "price": %s,
                  "description": "Produto criado para automacao de API",
                  "image": "https://placehold.co/600x400",
                  "category": "electronics"
                }
                """.formatted(titulo, preco);

        Response response = given()
                .contentType("application/json")
                .body(body)
        .when()
                .post("/products");

        response.then()
                .statusCode(201);

        int produtoId = response.jsonPath().getInt("id");

        System.out.println("Produto criado: " + titulo + " | ID: " + produtoId);

        return produtoId;
    }
    
private static int criarCarrinho(int userId, int produtoId1, int produtoId2) {

    String body = """
            {
              "userId": %d,
              "date": "2026-09-14",
              "products": [
                {
                  "productId": %d,
                  "quantity": 1
                },
                {
                  "productId": %d,
                  "quantity": 2
                }
              ]
            }
            """.formatted(userId, produtoId1, produtoId2);

    Response response = given()
            .contentType("application/json")
            .body(body)
    .when()
            .post("/carts");

    response.then()
        .statusCode(201)
        .body("userId", equalTo(userId))
        .body("products[0].productId", equalTo(produtoId1))
        .body("products[1].productId", equalTo(produtoId2));

    int carrinhoId = response.jsonPath().getInt("id");

    System.out.println("Carrinho criado | ID: " + carrinhoId);

    return carrinhoId;
}

private static Response consultarCarrinho(int carrinhoId) {

    Response response = given()
    .when()
            .get("/carts/" + carrinhoId);

     response.then()
            .statusCode(200)
            .body("id", equalTo(carrinhoId))
            .body("userId", equalTo(1))
            .body("products.size()", greaterThan(0));

    System.out.println("Carrinho consultado:");
    response.prettyPrint();

    return response;
}

private static void deletarCarrinho(int carrinhoId) {

    Response response = given()
    .when()
            .delete("/carts/" + carrinhoId);

    response.then()
            .statusCode(200);

    System.out.println("Carrinho deletado | ID: " + carrinhoId);
}

    @Test
    void deveCriarDoisProdutosComSucesso() {

        int produtoId1 = criarProduto("Produto 1 - Teste QA", 99.90);
        int produtoId2 = criarProduto("Produto 2 - Teste QA", 149.90);

        int carrinhoId = criarCarrinho(1, produtoId1, produtoId2);

        System.out.println("ID Produto 1: " + produtoId1);
        System.out.println("ID Produto 2: " + produtoId2);
        System.out.println("ID Carrinho: " + carrinhoId);

    }

    @Test
    void deveConsultarCarrinhoExistenteComSucesso() {
        consultarCarrinho(1);
}
    @Test
    void deveDeletarCarrinhoExistenteComSucesso() {
    deletarCarrinho(1);
}
    }
