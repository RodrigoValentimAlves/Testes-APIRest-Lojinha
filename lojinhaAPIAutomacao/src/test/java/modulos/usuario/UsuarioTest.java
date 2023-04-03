package modulos.usuario;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.UsuarioPojo;

@DisplayName("Testes de API Rest do modulo de Usuario")
public class UsuarioTest {

    private String token;
    @BeforeEach
    public void beforeEach(){
        // Configurando os dados da API Rest da lojinha
        baseURI = "http://165.227.93.41";
        //port = 8080;
        basePath ="/lojinha";
    }
    @Test
    @DisplayName("Adicionar um novo usuario valido")
    public void testAdicionarUmNovoUsuarioValido(){

        // Criar um novo usuario valido
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioNome\": \"Rodrigo\",\n" +
                        "  \"usuarioLogin\": \"RodrigoValentim12\",\n" +
                        "  \"usuarioSenha\": \"123456789\"\n" +
                        "}")

                .when()
                    .post("/v2/usuarios")
                .then()
                    .assertThat()
                    .body("message", equalTo("Usuário adicionado com sucesso"))
                    .statusCode(201);
    }

}
