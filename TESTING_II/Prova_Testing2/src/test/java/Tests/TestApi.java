package Tests;
import io.restassured.RestAssured;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
public class TestApi {

    @BeforeEach
    public void loginUser() {
        RestAssured.baseURI = "https://parabank.parasoft.com/parabank/";
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("username", "joaolindao1112");
        jsonObject.put("password", "minhaSenhatop57@");

        given()
                .body(jsonObject)
                .and()
                .when()
                .post("login.html");

    }

    @Test
    // Registro URL
    public void testeRegistroURL() {
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("customer.firstName", "Joana");
        jsonObject.put("customer.lastName", "Patricia");
        jsonObject.put("customer.address", "street: Rua da sua casa");
        jsonObject.put("customer.address", "city: Salvador");
        jsonObject.put("customer.address", "state: BA");
        jsonObject.put("customer.address", "zipCode: 42708-830");
        jsonObject.put("customer.phoneNumber", "(71) 9171-3860");
        jsonObject.put("customer.ssn", " 10");
        jsonObject.put("customer.username", "joanalindinha");
        jsonObject.put("customer.password", "05465468ssas@A");

        given()
                .body(new Gson().toJson(jsonObject))
                .and()
                .when()
                .get("register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    //	Abertura de nova conta URL
    public void openNewAccount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", "50550");
        jsonObject.put("newAccountType", "1");
        jsonObject.put("fromAccountId", "25268");


        given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("services_proxy/bank/createAccount?customerId=50550&newAccountType=1&fromAccountId=25268")
                .then()
                .statusCode(401);
    }

    @Test
    //Visão geral das contas URL:
    public void visaoGeralOverview() {
        given()
                .when()
                .get("overview.htm")
                .then()
                .statusCode(500);
    }

    @Test
    //Transferir Fundos URL:
    public void transferFounds() {
        given()
                .when()
                .post("services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=10")
                .then()
                .statusCode(401);
    }

    @Test
    //Atividades da conta (todos od meses) URL:
    public void ActiveAccountAllMonth() {
        given()
                .when()
                .get("services_proxy/bank/accounts/13566/transactions/month/All/type/All")
                .then()
                .statusCode(401);

    }

}
