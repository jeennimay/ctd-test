import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_Aula_18 {

    @Test
    public void givenThatPerfomAPostResquest_whenIGetTheResponseCode_thenTheResponseStatusCodeIs200(){
        //definindo o objeto a ser criado
        JSONObject jsonObject = new JSONObject();
                jsonObject.put("thumbnail", "https://s2.glbimg.com/4aBlWTjxzYoZwjpBtWCrtqkaHOc=/e.glbimg.com/og/ed/f/original/2022/02/01/botoes-cachorro-caramelo-bambino_1.png");
                jsonObject.put("name", "Toto marrom");
                jsonObject.put("realName", "JB");
                jsonObject.put("location", "Ap");
                jsonObject.put("isAlive", true);

                //criando
                given()
                        .header("Content-type", "application/json")
                        .contentType(ContentType.JSON)
                        .body(jsonObject.toString())
                        .when()
                        .post("https://restool-sample-app.herokuapp.com/api/character")
                        .then()
                        .statusCode(200);
    }
}
